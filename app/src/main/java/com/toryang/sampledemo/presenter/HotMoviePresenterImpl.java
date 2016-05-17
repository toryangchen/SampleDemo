package com.toryang.sampledemo.presenter;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.toryang.sampledemo.api.InitRetrofit;
import com.toryang.sampledemo.api.NetService;
import com.toryang.sampledemo.config.IPAddress;
import com.toryang.sampledemo.entities.comingSoon.ComingSoon;
import com.toryang.sampledemo.entities.inthreat.InThreatEntity;
import com.toryang.sampledemo.entities.usbox.UsBoxEntity;
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

    private boolean USBOX_FINISHED = false;
    private boolean HOTMO_FINISHED = false;
    private boolean RECENT_FINISHED = false;

    Log log = Log.YLog();
    Context context;

    UsBoxEntity usBoxentity;
    ComingSoon comingSoonEntity;
    InThreatEntity inThreatentity;
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

    public void loadData(){
        usBoxMovie();
        loadUsBox();
        recentMovie();
    }

    public void usBoxMovie(){
        InitRetrofit.createApi(NetService.class)
                .getHotMovie()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UsBoxEntity>() {
                    @Override
                    public void onCompleted() {
                        HOTMO_FINISHED = true;
                        log.d("finished");
                        update();
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError(null);
                        HOTMO_FINISHED = true;
                        log.e(e.toString());
                    }

                    @Override
                    public void onNext(UsBoxEntity usBoxEntity) {
                        usBoxentity = usBoxEntity;
                        log.d(usBoxEntity.getTitle()+"");
                    }
                });
    }

    public void loadUsBox(){
        InitRetrofit.createApi(NetService.class)
                .getInTheaters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InThreatEntity>() {
                    @Override
                    public void onCompleted() {
                        USBOX_FINISHED = true;
                        log.d("finished");
                        update();
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError(null);
                        USBOX_FINISHED = true;
                        log.e(e.toString());
                    }

                    @Override
                    public void onNext(InThreatEntity inThreatEntity ) {
                        inThreatentity = inThreatEntity;

                    }
                });

    }

    public void recentMovie(){
        InitRetrofit.createApi(NetService.class)
                .getComingSoon()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ComingSoon>() {
                    @Override
                    public void onCompleted() {
                        log.d("finished");
                        RECENT_FINISHED = true;
                        update();
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError(null);
                        RECENT_FINISHED = true;
                        log.e(e.toString());
                    }

                    @Override
                    public void onNext(ComingSoon comingSoon) {
                        comingSoonEntity = comingSoon;
                    }
                });
    }

    public void update(){
        if (USBOX_FINISHED && RECENT_FINISHED && HOTMO_FINISHED){
            getMvpView().loadData(usBoxentity,comingSoonEntity,inThreatentity);
        }
    }



    public void loadHotMovieWithVolley(){

        RequestQueue mQueue = Volley.newRequestQueue(context);
//        StringRequest request = new StringRequest("http://www.baidu.com", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                log.d(response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                log.e(error);
//            }
//        });
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
//        mQueue.add(request);
        mQueue.add(jsonObjectRequest);
    }
}
