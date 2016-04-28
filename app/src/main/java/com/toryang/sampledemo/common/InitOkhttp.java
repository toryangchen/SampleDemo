package com.toryang.sampledemo.common;

import android.support.annotation.Nullable;

import com.toryang.sampledemo.App;
import com.toryang.sampledemo.utils.NetworkUtils;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by toryang on 16/4/28.
 */
public class InitOkhttp {

    public static OkHttpClient client = new OkHttpClient
            .Builder()
            .cache(new Cache(getFile(),1024*1024*10))
            .addNetworkInterceptor(new PInterceptor())
            .build();

    final static @Nullable File baseDir = App.getInstace().getCacheDir();

    public static File getFile(){
        if (baseDir!=null){
            File cacheDir = new File(baseDir,"HttpResponseCache");
            return cacheDir;
        }
        return baseDir;
    }


    public static class PInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            if (!NetworkUtils.isNetworkConnected()){
                request = request
                        .newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }

            Response originalResponse = chain.proceed(request);
            return originalResponse.newBuilder()
                    .header("Cache-Control","public,max-age=3600")
                    .removeHeader("Pragma").build();
        }
    }


    public static OkHttpClient getClient(){
        return client;
    }

}
