package com.toryang.sampledemo.presenter;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.toryang.sampledemo.api.InitRetrofit;
import com.toryang.sampledemo.api.NetService;
import com.toryang.sampledemo.config.IPAddress;
import com.toryang.sampledemo.ui.view.DataView;
import com.toryang.sampledemo.utils.Log;

import org.json.JSONObject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by toryang on 16/4/26.
 */
public class HotMoviePresenterImpl extends BasePresenter<DataView>{

    Log log = Log.YLog();
    Context context;

    public HotMoviePresenterImpl(Context context){
        this.context = context;
    }

    @Override
    public void attachView(DataView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void loadHotMovie(){

        InitRetrofit.createApi(NetService.class)
                .getHotMovie()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onCompleted() {
                        log.d("finished");
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError(null,null);
                        log.e(e.getStackTrace());
                    }

                    @Override
                    public void onNext(Object o) {
                        getMvpView().loadMore();
                        log.d(o.toString());
                    }
                });
    }

    public void loadHotMovieWithVolley(){

        RequestQueue mQueue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest("http://www.baidu.com", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                log.d(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                log.e(error);
            }
        });


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(IPAddress.totalUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        log.d(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                log.e(error);
            }
        });
        mQueue.add(request);
        mQueue.add(jsonObjectRequest);
    }
}
