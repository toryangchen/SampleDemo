package com.toryang.sampledemo.ui.view;

import com.toryang.sampledemo.entities.movieEntitiy.Movieinfo;
import com.toryang.sampledemo.entities.usbox.UsBoxEntity;

/**
 * Created by toryang on 16/4/27.
 */
public interface DataView extends MvpView {

    void loadData(UsBoxEntity usBoxEntity, Movieinfo comingSoon, Movieinfo inThreatEntity);

}
