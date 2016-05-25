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

import com.toryang.sampledemo.entities.movieEntitiy.Subject;
import com.toryang.sampledemo.entities.usbox.Subject_;
import com.toryang.sampledemo.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by toryang on 5/25/16.
 */
public class MovieInfoActivity extends BaseActivity {


    public static Subject_ mUsBoxSubject;
    public static Subject subject;

    Picasso picasso = App.getPicasso();


    public static void startActivity(Context context, Subject_ usBoxSubject) {
        mUsBoxSubject = usBoxSubject;
        Intent intent = new Intent(context, MovieInfoActivity.class);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Subject movieSubject) {
        subject = movieSubject;
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
        }else {
            collapsingToolbar.setTitle(subject.getTitle());
            picasso.with(this).load(subject.getImages().getLarge()).into(image);
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
        subject = null;
    }
}
