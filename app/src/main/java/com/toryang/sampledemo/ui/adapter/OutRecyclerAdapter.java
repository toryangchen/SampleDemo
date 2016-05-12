package com.toryang.sampledemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.toryang.sampledemo.R;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by toryang on 5/12/16.
 */
public class OutRecyclerAdapter extends RecyclerView.Adapter<OutRecyclerAdapter.MyViewHolder> {

    @BindArray(R.array.movie_title)
    String[] title;

    private Context mContext;
    private LayoutInflater mLayoutInflater;


    OutRecyclerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(mLayoutInflater.inflate(R.layout.menu_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // FIXME: 5/12/16 write data
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_hotmovie)
        TextView tvHotmovie;
        @BindView(R.id.image_pic_one)
        ImageView imagePicOne;
        @BindView(R.id.tv_movie_name_one)
        TextView tvMovieNameOne;
        @BindView(R.id.image_pic_two)
        ImageView imagePicTwo;
        @BindView(R.id.tv_movie_name_two)
        TextView tvMovieNameTwo;
        @BindView(R.id.image_pic_three)
        ImageView imagePicThree;
        @BindView(R.id.tv_movie_name_three)
        TextView tvMovieNameThree;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
