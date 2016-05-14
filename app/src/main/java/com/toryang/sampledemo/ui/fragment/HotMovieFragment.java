package com.toryang.sampledemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.IconHintView;
import com.toryang.sampledemo.R;
import com.toryang.sampledemo.model.entities.comingSoon.ComingSoon;
import com.toryang.sampledemo.model.entities.inthreat.InThreatEntity;
import com.toryang.sampledemo.model.entities.usbox.UsBoxEntity;
import com.toryang.sampledemo.presenter.HotMoviePresenterImpl;
import com.toryang.sampledemo.ui.BaseFragment;
import com.toryang.sampledemo.ui.adapter.LoopAdapter;
import com.toryang.sampledemo.ui.view.DataView;
import com.toryang.sampledemo.utils.Log;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by toryang on 16/4/26.
 */
public class HotMovieFragment extends BaseFragment implements DataView {

    @BindView(R.id.roll_view_pager)
    RollPagerView mRollViewPager;
    @BindView(R.id.recycler_movie)
    RecyclerView recyclerMovie;

    private HotMoviePresenterImpl presenter;


    Log log = Log.YLog();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HotMoviePresenterImpl(getActivity());
        presenter.attachView(this);
        presenter.loadData();
//        presenter.loadHotMovieWithVolley();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotmovie, container, false);
        ButterKnife.bind(this, view);
        operateView();
        return view;
    }

    public void operateView() {
        mRollViewPager.setPlayDelay(1000);
        mRollViewPager.setAnimationDurtion(500);
        mRollViewPager.setAdapter(new LoopAdapter(mRollViewPager));
        mRollViewPager.setHintView(new IconHintView(getContext(), R.drawable.point_focus, R.drawable.point_normal));

        recyclerMovie.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

    }


    /**
     * Presenter 的回调接口，用于更新UI
     */

    @Override
    public void refresh(UsBoxEntity usBoxEntity) {


    }

    @Override
    public void loadMore(UsBoxEntity usBoxEntity) {

    }

    @Override
    public void loadData(UsBoxEntity usBoxEntity, ComingSoon comingSoon, InThreatEntity inThreatEntity) {
        log.d("here");
        log.d(usBoxEntity.getTitle()+":"+comingSoon.getTitle()+":"+inThreatEntity.getTitle());
    }


}
