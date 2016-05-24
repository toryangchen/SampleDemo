package com.toryang.sampledemo.ui.view;

import com.toryang.sampledemo.entities.top250.Top250Entity;

/**
 * Created by toryang on 5/24/16.
 */
public interface TopDataView extends MvpView {

    void dataBack(Top250Entity top250Entity);
}
