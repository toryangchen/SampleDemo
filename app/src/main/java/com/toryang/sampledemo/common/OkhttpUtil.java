package com.toryang.sampledemo.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Environment;

import com.toryang.sampledemo.utils.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by toryang on 5/15/16.
 */
public class OkhttpUtil {
    Log log = Log.YLog();
    String url;
    public OkhttpUtil(String url){
        this.url = url;
    }

    /**
     * download bitmap image；
     */
    public Observable<Bitmap> downloadDrawble = Observable.create(new Observable.OnSubscribe<Bitmap>() {
        @Override
        public void call(Subscriber<? super Bitmap> subscriber) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()){
                    InputStream input = response.body().byteStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(input);
                    subscriber.onNext(bitmap);
                }
            }catch (IOException e){
                subscriber.onError(e);
            }
        }
    });


    File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    File file = new File(path,"/pathtofile");

    /**
     * download file with OkHttp and RxJava (rate)
     */
    public Observable<String> downloadObservable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            InputStream inputStream = null;
            OutputStream outputStream = null;
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            try{
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()){
                    inputStream = response.body().byteStream();
                    long length = response.body().contentLength();
                    outputStream = new FileOutputStream(file);
                    byte data[] = new byte[1024];
                    subscriber.onNext("0%");
                    long total = 0;
                    int count;
                    while ((count = inputStream.read(data)) != -1){
                        total += count;
                        subscriber.onNext(String.valueOf(total*100/length) + "%");
                        outputStream.write(data,0,count);
                    }
                    outputStream.flush();
                    outputStream.close();
                    inputStream.close();

                }

            }catch (IOException e){
                subscriber.onError(e);
            }finally {
                if (inputStream != null){
                    try{
                        inputStream.close();
                    }catch (IOException e){}
                }
                if (outputStream != null){
                    try {
                        outputStream.close();
                    }catch (IOException e){}
                }
            }
            subscriber.onCompleted();
        }
    });
}
