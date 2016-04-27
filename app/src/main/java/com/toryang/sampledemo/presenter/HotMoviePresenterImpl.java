package com.toryang.sampledemo.presenter;

import android.net.NetworkRequest;
import android.support.annotation.MainThread;

import com.toryang.sampledemo.api.InitRetrofit;
import com.toryang.sampledemo.api.NetService;
import com.toryang.sampledemo.model.HotMovieModel;
import com.toryang.sampledemo.model.HotMovieModelImpl;
import com.toryang.sampledemo.ui.view.DataView;
import com.toryang.sampledemo.ui.view.IhotView;
import com.toryang.sampledemo.utils.Log;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.Subject;

/**
 * Created by toryang on 16/4/26.
 */
public class HotMoviePresenterImpl extends BasePresenter<DataView>{

    Log log = Log.YLog();

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
}
