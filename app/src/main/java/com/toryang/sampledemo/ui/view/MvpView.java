package com.toryang.sampledemo.ui.view;

import android.view.View;

/**
 * Created by toryang on 16/4/27.
 */
public interface MvpView {

    void startLoading();

    void hideLoading();

    void showError(String msg);


}
