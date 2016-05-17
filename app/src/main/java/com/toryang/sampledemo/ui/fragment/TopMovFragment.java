package com.toryang.sampledemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toryang.sampledemo.entities.comingSoon.ComingSoon;
import com.toryang.sampledemo.entities.inthreat.InThreatEntity;
import com.toryang.sampledemo.entities.usbox.UsBoxEntity;
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
    public void loadData(UsBoxEntity usBoxEntity, ComingSoon comingSoon, InThreatEntity inThreatEntity) {

    }
}
