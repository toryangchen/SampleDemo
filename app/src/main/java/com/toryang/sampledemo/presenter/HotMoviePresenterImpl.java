package com.toryang.sampledemo.presenter;

import com.toryang.sampledemo.model.HotMovieModel;
import com.toryang.sampledemo.model.HotMovieModelImpl;
import com.toryang.sampledemo.view.IhotView;

/**
 * Created by toryang on 16/4/26.
 */
public class HotMoviePresenterImpl implements HotMoviePresenter,OnGetInfoFinishedListener{

    private IhotView ihotView;
    private HotMovieModel hotMovieModel;

    public HotMoviePresenterImpl(IhotView ihotView){
        this.ihotView = ihotView;
        hotMovieModel = new HotMovieModelImpl();
    }

    @Override
    public void getInfo() {

        hotMovieModel.getinfo(this);
    }

    @Override
    public void onDestory() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailed() {

    }

    @Override
    public void onNext() {

    }
}
