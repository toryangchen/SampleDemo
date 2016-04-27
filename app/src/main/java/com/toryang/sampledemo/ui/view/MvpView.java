package com.toryang.sampledemo.ui.view;

import android.view.View;

/**
 * Created by toryang on 16/4/27.
 */
public interface MvpView {

    void showLoading(String msg);

    void hideLoading();

    void showError(String msg, View.OnClickListener onClickListener);

    void showEmpty(String msg, View.OnClickListener onClickListener);

    void showEmpty(String msg, View.OnClickListener onClickListener, int imagId);

    void showNetError(View.OnClickListener onClickListener);

}
