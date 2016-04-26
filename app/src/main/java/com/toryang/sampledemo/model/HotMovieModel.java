package com.toryang.sampledemo.model;

import com.toryang.sampledemo.presenter.OnGetInfoFinishedListener;

/**
 * Created by toryang on 16/4/26.
 */
public interface HotMovieModel {

    void getinfo(OnGetInfoFinishedListener listener);
}
