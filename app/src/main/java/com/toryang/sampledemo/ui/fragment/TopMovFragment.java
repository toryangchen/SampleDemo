package com.toryang.sampledemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toryang.sampledemo.R;
import com.toryang.sampledemo.entities.movieEntitiy.Movieinfo;
import com.toryang.sampledemo.loading.MyLoading;
import com.toryang.sampledemo.presenter.Top250PresenterImpl;
import com.toryang.sampledemo.ui.BaseFragment;
import com.toryang.sampledemo.ui.activity.MovieInfoActivity;
import com.toryang.sampledemo.ui.adapter.GridAdapter;
import com.toryang.sampledemo.ui.adapter.GridItemClick;
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
    @BindView(R.id.loading)
    MyLoading loading;

    private Top250PresenterImpl presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_gridmovie, container, false);
        ButterKnife.bind(this, view);
        setMyLoading(loading);
        presenter = new Top250PresenterImpl(getActivity());
        presenter.attachView(this);
        presenter.getTop250();
        return view;
    }

    @Override
    public void dataBack(final Movieinfo top250Entity) {
        int spaceCount = 3;
        int spacing = 40;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),spaceCount);
        rvMovieinfo.addItemDecoration(new GridSpacingItemDecoration(spaceCount,spacing,true));
        rvMovieinfo.setLayoutManager(gridLayoutManager);
        rvMovieinfo.setHasFixedSize(true);
        GridAdapter adapter = new GridAdapter(getActivity(),top250Entity);
        rvMovieinfo.setAdapter(adapter);
        rvMovieinfo.addOnItemTouchListener(new GridItemClick(getActivity(), new GridItemClick.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                MovieInfoActivity.startActivity(getActivity(),top250Entity.getSubjects().get(position));
            }
        }));
    }
}
