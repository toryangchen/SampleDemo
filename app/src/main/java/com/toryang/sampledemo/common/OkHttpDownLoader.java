package com.toryang.sampledemo.common;

import android.net.Uri;

import com.squareup.picasso.Downloader;
import com.squareup.picasso.NetworkPolicy;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by toryang on 16/4/28.
 */
public class OkHttpDownLoader implements Downloader{

    OkHttpClient mClient = null;
    public OkHttpDownLoader(OkHttpClient client){
        mClient = client;
    }

    @Override
    public Response load(Uri uri, int networkPolicy) throws IOException {
        CacheControl.Builder builder = new CacheControl.Builder();
        if (networkPolicy != 0){
            if (NetworkPolicy.isOfflineOnly(networkPolicy)){
                builder.onlyIfCached();
            }else {
                if (!NetworkPolicy.shouldReadFromDiskCache(networkPolicy)){
                    builder.noCache();
                }
                if (!NetworkPolicy.shouldWriteToDiskCache(networkPolicy)){
                    builder.noStore();
                }
            }
        }

        Request request = new Request.Builder()
                .cacheControl(builder.build())
                .url(uri.toString())
                .build();

        okhttp3.Response response = mClient.newCall(request).execute();
        return new Response(response.body().byteStream(),false,response.body().contentLength());
    }

    @Override
    public void shutdown() {

    }
}
