package com.toryang.sampledemo.api;

import com.toryang.sampledemo.config.IPAddress;
import com.toryang.sampledemo.utils.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by toryang on 16/4/26.
 */
public class InitRetrofit {

    static Log log = Log.YLog();

    static OkHttpClient client = new OkHttpClient();

    static {
        client.interceptors().add(new LoggingIntercepter());
        client.interceptors().add(new GzipRequsetInterceptor());
    }

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(IPAddress.url)
            .client(client)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    static class LoggingIntercepter implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            long t1 = System.nanoTime();
            log.d(String.format("Sending request %s on %s%n%s",
                    request.url(),chain.connection(),request.headers()));

            Response response = chain.proceed(request);
            long t2 = System.nanoTime();
            log.d(String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(),(t2-t1)/1e6d, response.headers()));
            return null;
        }
    }

    static class GzipRequsetInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            if (originalRequest.body() == null || originalRequest.header("Content-Encoding") != null) {
                return chain.proceed(originalRequest);
            }

            Request compressedRequest = originalRequest.newBuilder()
                    .header("Content-Encoding","gzip")
                    .method(originalRequest.method(),gzip(originalRequest.body()))
                    .build();
            return chain.proceed(compressedRequest);
        }

        private RequestBody gzip(final RequestBody body){
            return new RequestBody() {
                @Override
                public MediaType contentType() {
                    return body.contentType();
                }

                @Override
                public long contentLength() throws IOException {
                    return -1;
                }

                @Override
                public void writeTo(BufferedSink sink) throws IOException {
                    BufferedSink gzipSink = Okio.buffer(new GzipSink(sink));
                    body.writeTo(gzipSink);
                    gzipSink.close();
                }
            };
        }

    }

    private InitRetrofit(){

    }

    public static <T> T createApi(Class<T> mClass){

        return retrofit.create(mClass);
    }

}
