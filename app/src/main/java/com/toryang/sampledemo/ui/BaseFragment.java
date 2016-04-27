package com.toryang.sampledemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toryang.sampledemo.ui.view.MvpView;

/**
 * Created by toryang on 16/4/26.
 */
public class BaseFragment extends Fragment implements MvpView {


    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg, View.OnClickListener onClickListener) {

    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener) {

    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener, int imagId) {

    }

    @Override
    public void showNetError(View.OnClickListener onClickListener) {

    }
}
