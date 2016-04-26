package com.toryang.sampledemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.IconHintView;
import com.toryang.sampledemo.R;
import com.toryang.sampledemo.adapter.LoopAdapter;
import com.toryang.sampledemo.base.BaseFragment;
import com.toryang.sampledemo.view.IhotView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by toryang on 16/4/26.
 */
public class HotMovieFragment extends BaseFragment implements IhotView {

    @BindView(R.id.roll_view_pager)RollPagerView mRollViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotmovie,container,false);
        ButterKnife.bind(this,view);
        operateView();
        return view;
    }

    @Override
    public void operateView() {
        mRollViewPager.setPlayDelay(1000);
        mRollViewPager.setAnimationDurtion(500);
        mRollViewPager.setAdapter(new LoopAdapter(mRollViewPager));
        mRollViewPager.setHintView(new IconHintView(getContext(),R.drawable.point_focus,R.drawable.point_normal));
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void cancelProgress() {

    }

    @Override
    public void setView() {

    }
}
