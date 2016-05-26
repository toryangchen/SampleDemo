package com.toryang.sampledemo.ui.view;

import com.toryang.sampledemo.entities.movieEntitiy.Movieinfo;

/**
 * Created by toryang on 5/24/16.
 */
public interface TopDataView extends MvpView {

    void dataBack(Movieinfo top250Entity);

}
