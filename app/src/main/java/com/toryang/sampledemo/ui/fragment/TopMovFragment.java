package com.toryang.sampledemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toryang.sampledemo.R;
import com.toryang.sampledemo.entities.top250.Top250Entity;
import com.toryang.sampledemo.presenter.Top250PresenterImpl;
import com.toryang.sampledemo.ui.BaseFragment;
import com.toryang.sampledemo.ui.adapter.GridAdapter;
import com.toryang.sampledemo.ui.adapter.GridSpacingItemDecoration;
import com.toryang.sampledemo.ui.view.TopDataView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by toryang on 16/4/27.
 */
public class TopMovFragment extends BaseFragment implements TopDataView {

    @BindView(R.id.rv_movieinfo)
    RecyclerView rvMovieinfo;


    private Top250PresenterImpl presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new Top250PresenterImpl(getActivity());
        presenter.attachView(this);
        presenter.getTop250();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_movieinfo, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void dataBack(Top250Entity top250Entity) {
        int spaceCount = 3;
        int spacing = 40;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),spaceCount);
        rvMovieinfo.addItemDecoration(new GridSpacingItemDecoration(spaceCount,spacing,true));
        rvMovieinfo.setLayoutManager(gridLayoutManager);
        rvMovieinfo.setHasFixedSize(true);
        GridAdapter adapter = new GridAdapter(getActivity(),top250Entity);
        rvMovieinfo.setAdapter(adapter);
    }
}
