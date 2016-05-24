package com.toryang.sampledemo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.toryang.sampledemo.R;
import com.toryang.sampledemo.entities.comingSoon.ComingSoon;
import com.toryang.sampledemo.entities.inthreat.InThreatEntity;
import com.toryang.sampledemo.entities.usbox.UsBoxEntity;
import com.toryang.sampledemo.ui.BaseActivity;
import com.toryang.sampledemo.ui.adapter.GridAdapter;
import com.toryang.sampledemo.utils.Log;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by toryang on 5/24/16.
 */
public class MovieInfoActivity extends BaseActivity {

    Log log = Log.YLog();

    public static   UsBoxEntity mUsBoxEntity;
    public static   ComingSoon mComingSoon;
    public static InThreatEntity mInThreatEntity;

    @BindView(R.id.rv_movieinfo)
    RecyclerView rvMovieinfo;

    public static void startActivity(Context context, UsBoxEntity usBoxEntity) {
        mUsBoxEntity = usBoxEntity;
        Intent intent = new Intent(context, MovieInfoActivity.class);

        context.startActivity(intent);
    }

    public static void startActivity(Context context, ComingSoon comingSoon) {
        mComingSoon = comingSoon;
        Intent intent = new Intent(context, MovieInfoActivity.class);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, InThreatEntity inThreatEntity) {
        mInThreatEntity = inThreatEntity;
        Intent intent = new Intent(context, MovieInfoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movieinfo);
        ButterKnife.bind(this);
//        operateView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        operateView();
    }

    @Override
    public void operateView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        rvMovieinfo.setLayoutManager(gridLayoutManager);
        rvMovieinfo.setHasFixedSize(true);
        GridAdapter gridAdapter;
        if (mUsBoxEntity != null) {
            gridAdapter= new GridAdapter(this,mUsBoxEntity);
            log.d(mUsBoxEntity.getTitle());
            mUsBoxEntity = null;
        } else if (mComingSoon != null) {
            gridAdapter = new GridAdapter(this,mComingSoon);
            log.d(mComingSoon.getTitle());
            mComingSoon = null;
        } else {
            gridAdapter = new GridAdapter(this,mInThreatEntity);
            log.d(mInThreatEntity.getTitle());
            mInThreatEntity = null;
        }
        rvMovieinfo.setAdapter(gridAdapter);

    }
}
