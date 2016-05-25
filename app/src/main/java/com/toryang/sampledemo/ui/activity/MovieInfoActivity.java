package com.toryang.sampledemo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.toryang.sampledemo.App;
import com.toryang.sampledemo.R;
import com.toryang.sampledemo.entities.comingSoon.Subject;
import com.toryang.sampledemo.entities.usbox.Subject_;
import com.toryang.sampledemo.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by toryang on 5/25/16.
 */
public class MovieInfoActivity extends BaseActivity {


    public static Subject_ mUsBoxSubject;
    public static Subject mComingSoonSuject;
    public static com.toryang.sampledemo.entities.inthreat.Subject mInThreatSubject;
    public static com.toryang.sampledemo.entities.top250.Subject mTop250Subject;
    Picasso picasso = App.getPicasso();


    public static void startActivity(Context context, Subject_ usBoxSubject) {
        mUsBoxSubject = usBoxSubject;
        Intent intent = new Intent(context, MovieInfoActivity.class);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Subject ComingSoonSuject) {
        mComingSoonSuject = ComingSoonSuject;
        Intent intent = new Intent(context, MovieInfoActivity.class);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, com.toryang.sampledemo.entities.inthreat.Subject inThreatSubject) {
        mInThreatSubject = inThreatSubject;
        Intent intent = new Intent(context, MovieInfoActivity.class);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, com.toryang.sampledemo.entities.top250.Subject top250Subject) {
        mTop250Subject = top250Subject;
        Intent intent = new Intent(context, MovieInfoActivity.class);
        context.startActivity(intent);
    }

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movieinfo);
        ButterKnife.bind(this);
        operateView();
    }

    @Override
    public void operateView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (mUsBoxSubject != null){
            collapsingToolbar.setTitle(mUsBoxSubject.getTitle());
            picasso.with(this).load(mUsBoxSubject.getImages().getLarge()).into(image);
        }else if (mComingSoonSuject != null){
            collapsingToolbar.setTitle(mComingSoonSuject.getTitle());
            picasso.with(this).load(mComingSoonSuject.getImages().getLarge()).into(image);
        }else if (mInThreatSubject != null){
            collapsingToolbar.setTitle(mInThreatSubject.getTitle());
            picasso.with(this).load(mInThreatSubject.getImages().getLarge()).into(image);
        }else {
            collapsingToolbar.setTitle(mTop250Subject.getTitle());
            picasso.with(this).load(mTop250Subject.getImages().getLarge()).into(image);
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUsBoxSubject = null;
        mComingSoonSuject = null;
        mInThreatSubject = null;
        mTop250Subject = null;

    }
}
