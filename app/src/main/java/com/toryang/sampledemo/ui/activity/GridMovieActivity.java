package com.toryang.sampledemo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.toryang.sampledemo.R;
import com.toryang.sampledemo.entities.comingSoon.ComingSoon;
import com.toryang.sampledemo.entities.inthreat.InThreatEntity;
import com.toryang.sampledemo.entities.usbox.UsBoxEntity;
import com.toryang.sampledemo.ui.BaseActivity;
import com.toryang.sampledemo.ui.adapter.GridAdapter;
import com.toryang.sampledemo.ui.adapter.GridItemClick;
import com.toryang.sampledemo.ui.adapter.GridSpacingItemDecoration;
import com.toryang.sampledemo.utils.Log;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by toryang on 5/24/16.
 */
public class GridMovieActivity extends BaseActivity {

    Log log = Log.YLog();

    public static   UsBoxEntity mUsBoxEntity;
    public static   ComingSoon mComingSoon;
    public static InThreatEntity mInThreatEntity;

    @BindView(R.id.rv_movieinfo)
    RecyclerView rvMovieinfo;
    @BindArray(R.array.movie_title)
    String[] movie;

    public static void startActivity(Context context, UsBoxEntity usBoxEntity) {
        mUsBoxEntity = usBoxEntity;
        Intent intent = new Intent(context, GridMovieActivity.class);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, ComingSoon comingSoon) {
        mComingSoon = comingSoon;
        Intent intent = new Intent(context, GridMovieActivity.class);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, InThreatEntity inThreatEntity) {
        mInThreatEntity = inThreatEntity;
        Intent intent = new Intent(context, GridMovieActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridmovie);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        operateView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void operateView() {
        int spanCount = 3;
        int spacing = 30;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,spanCount);
        rvMovieinfo.setLayoutManager(gridLayoutManager);
        rvMovieinfo.addItemDecoration(new GridSpacingItemDecoration(spanCount,spacing,true ));
        rvMovieinfo.setHasFixedSize(true);
        final GridAdapter gridAdapter;
        if (mUsBoxEntity != null) {
            gridAdapter= new GridAdapter(this,mUsBoxEntity);
            getSupportActionBar().setTitle(movie[2]);
        } else if (mComingSoon != null) {
            gridAdapter = new GridAdapter(this,mComingSoon);
            getSupportActionBar().setTitle(movie[1]);
        } else {
            gridAdapter = new GridAdapter(this,mInThreatEntity);
            getSupportActionBar().setTitle(movie[0]);
        }
        rvMovieinfo.setAdapter(gridAdapter);
        rvMovieinfo.addOnItemTouchListener(new GridItemClick(this,new GridItemClick.OnItemClickListener(){
                    @Override
                    public void onItemClick(View view, int position) {
                        if (mUsBoxEntity != null) {
                            MovieInfoActivity.startActivity(GridMovieActivity.this,mUsBoxEntity.getSubjects().get(position).getSubject());
                        } else if (mComingSoon != null) {
                            MovieInfoActivity.startActivity(GridMovieActivity.this,mComingSoon.getSubjects().get(position));
                        } else {
                            MovieInfoActivity.startActivity(GridMovieActivity.this,mInThreatEntity.getSubjects().get(position));
                        }
                    }
                })
        );
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUsBoxEntity = null;
        mComingSoon = null;
        mInThreatEntity = null;
    }
}
