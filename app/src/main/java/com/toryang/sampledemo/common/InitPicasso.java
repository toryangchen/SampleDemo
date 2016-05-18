package com.toryang.sampledemo.common;

import android.content.Context;

import com.squareup.picasso.Picasso;
import com.toryang.sampledemo.utils.Log;

import okhttp3.OkHttpClient;

/**
 * Created by toryang on 16/4/28.
 */
public class InitPicasso {

    private static OkHttpClient client = new OkHttpClient();

    public static Picasso getPicasso(Context context){
        Log.YLog().d("picasso here");
        Picasso picasso = new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(client))
                .build();
        Picasso.setSingletonInstance(picasso);
        return picasso;
    }

}
