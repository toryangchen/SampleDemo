package com.toryang.sampledemo.common;

import android.content.Context;
import android.net.Uri;
import android.os.StatFs;

import com.squareup.picasso.Downloader;
import com.squareup.picasso.NetworkPolicy;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/**
 * Created by toryang on 16/4/28.
 */
public class OkHttp3Downloader implements Downloader{

    private static final String PICASSO_CACHE = "picasso-cache";
    private static final int MIN_DISK_CACHE_SIZE = 5 * 1024 * 1024; // 5MB
    private static final int MAX_DISK_CACHE_SIZE = 50 * 1024 * 1024; // 50MB


    private static File createDefaultCacheDir(Context context){
        File cache = new File(context.getApplicationContext().getCacheDir(),PICASSO_CACHE);
        if (!cache.exists()){
            cache.mkdirs();
        }
        return cache;
    }

    private static long calculateDiskCacheSize(File dir){
        long size = MIN_DISK_CACHE_SIZE;

        try{
            StatFs statFs = new StatFs(dir.getAbsolutePath());
            long available = ((long)statFs.getBlockCount()) * statFs.getBlockSize();
            size = available / 50;
        }catch (IllegalArgumentException ignored){}

        return Math.max(Math.min(size,MAX_DISK_CACHE_SIZE),MIN_DISK_CACHE_SIZE);
    }


    private static OkHttpClient defaultOkHttpClient(File cacheDir, long maxSize){
        return new OkHttpClient.Builder()
                .cache(new okhttp3.Cache(cacheDir,maxSize))
                .build();
    }

    private final Call.Factory client;
    private final Cache cache;

    public OkHttp3Downloader(Context context){
        this(createDefaultCacheDir(context));
    }


    public OkHttp3Downloader(File cacheDir){
        this(cacheDir,calculateDiskCacheSize(cacheDir));
    }

    public OkHttp3Downloader(final Context context, final long maxSize) {
        this(createDefaultCacheDir(context), maxSize);
    }

    public OkHttp3Downloader(File cacheDir, long maxSize) {
        this(defaultOkHttpClient(cacheDir, maxSize));
    }

    public OkHttp3Downloader(OkHttpClient client) {
        this.client = client;
        this.cache = client.cache();
    }

    public OkHttp3Downloader(Call.Factory client) {
        this.client = client;
        this.cache = null;
    }

    @Override
    public Response load(Uri uri, int networkPolicy) throws IOException {
        CacheControl cacheControl = null;
        if (networkPolicy != 0){
            if (NetworkPolicy.isOfflineOnly(networkPolicy)){
                cacheControl = CacheControl.FORCE_CACHE;
            }else {
                CacheControl.Builder builder = new CacheControl.Builder();
                if (!NetworkPolicy.shouldReadFromDiskCache(networkPolicy)){
                    builder.noCache();
                }

                if (!NetworkPolicy.shouldWriteToDiskCache(networkPolicy)){
                    builder.noStore();
                }
                cacheControl = builder.build();
            }
        }

        Request.Builder builder = new Request.Builder().url(uri.toString());
        if (cacheControl != null){
            builder.cacheControl(cacheControl);
        }

        okhttp3.Response response = client.newCall(builder.build()).execute();
        int responseCode = response.code();
        if (responseCode >= 300){
            response.body().close();
            throw  new ResponseException(responseCode + " " + response.message(),networkPolicy,
                    responseCode);
        }

        boolean fromCache = response.cacheResponse() != null;
        
        ResponseBody responseBody = response.body();
        return new Response(responseBody.byteStream(),fromCache,responseBody.contentLength());
    }

    @Override
    public void shutdown() {
        if (cache != null){
            try{
                cache.close();
            }catch (IOException ignored){

            }
        }
    }
}
