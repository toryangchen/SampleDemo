package com.toryang.sampledemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.toryang.sampledemo.R;
import com.toryang.sampledemo.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by toryang on 5/25/16.
 */
public class MovieInfoActivity extends BaseActivity {

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
        collapsingToolbar.setTitle("here");
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
}
