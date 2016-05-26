package com.toryang.sampledemo.ui;

import android.support.v4.app.Fragment;
import android.view.View;

import com.toryang.sampledemo.loading.MyLoading;
import com.toryang.sampledemo.ui.view.MvpView;

/**
 * Created by toryang on 16/4/26.
 */
public class BaseFragment extends Fragment implements MvpView {

    MyLoading myLoading;

    public void setMyLoading(MyLoading myLoading) {
        this.myLoading = myLoading;
    }
    @Override
    public void startLoading() {
        myLoading.start();
    }

    @Override
    public void hideLoading() {
        myLoading.stop();
        myLoading.setVisibility(View.GONE);
    }

    @Override
    public void showError(String msg) {

    }
}
