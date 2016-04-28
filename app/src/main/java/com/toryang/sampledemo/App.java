package com.toryang.sampledemo;

import android.app.Application;

/**
 * Created by toryang on 16/4/28.
 */
public class App extends Application {

    private static App instace;

    public static App getInstace(){
        return instace;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instace = this;
    }
}
