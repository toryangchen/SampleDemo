package com.toryang.sampledemo.presenter;

import com.toryang.sampledemo.ui.view.MvpView;

/**
 * Created by toryang on 16/4/27.
 */
public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();

}
