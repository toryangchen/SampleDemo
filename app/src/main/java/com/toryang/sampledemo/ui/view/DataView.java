package com.toryang.sampledemo.ui.view;

import com.toryang.sampledemo.entities.comingSoon.ComingSoon;
import com.toryang.sampledemo.entities.inthreat.InThreatEntity;
import com.toryang.sampledemo.entities.usbox.UsBoxEntity;

/**
 * Created by toryang on 16/4/27.
 */
public interface DataView extends MvpView {

    void loadData(UsBoxEntity usBoxEntity, ComingSoon comingSoon, InThreatEntity inThreatEntity);

}
