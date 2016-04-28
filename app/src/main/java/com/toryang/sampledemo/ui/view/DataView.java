package com.toryang.sampledemo.ui.view;

import com.toryang.sampledemo.model.entities.usbox.UsBoxEntity;

/**
 * Created by toryang on 16/4/27.
 */
public interface DataView extends MvpView {

    void refresh(UsBoxEntity usBoxEntity);

    void loadMore(UsBoxEntity usBoxEntity);

}
