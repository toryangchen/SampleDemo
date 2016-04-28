package com.toryang.sampledemo.common;

import android.content.Context;

import com.squareup.picasso.Picasso;

/**
 * Created by toryang on 16/4/28.
 */
public class InitPicasso {

    public static Picasso getPicasso(Context context){
        Picasso picasso = new Picasso.Builder(context)
                .downloader(new OkHttpDownLoader(InitOkhttp.getClient()))
                .build();
        Picasso.setSingletonInstance(picasso);

        return picasso;
    }

}
