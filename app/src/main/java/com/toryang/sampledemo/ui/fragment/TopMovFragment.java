package com.toryang.sampledemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toryang.sampledemo.model.entities.usbox.UsBoxEntity;
import com.toryang.sampledemo.ui.BaseFragment;
import com.toryang.sampledemo.ui.view.DataView;

/**
 * Created by toryang on 16/4/27.
 */
public class TopMovFragment extends BaseFragment implements DataView {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void refresh(UsBoxEntity usBoxEntity) {

    }

    @Override
    public void loadMore(UsBoxEntity usBoxEntity) {

    }
}
