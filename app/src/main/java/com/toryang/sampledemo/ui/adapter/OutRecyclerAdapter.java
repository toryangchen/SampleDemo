package com.toryang.sampledemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.toryang.sampledemo.R;
import com.toryang.sampledemo.model.entities.comingSoon.ComingSoon;
import com.toryang.sampledemo.model.entities.inthreat.InThreatEntity;
import com.toryang.sampledemo.model.entities.usbox.UsBoxEntity;
import com.toryang.sampledemo.utils.Log;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by toryang on 5/12/16.
 */
public class OutRecyclerAdapter extends RecyclerView.Adapter<OutRecyclerAdapter.MyViewHolder> {
    Log log = Log.YLog();


    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private UsBoxEntity usBoxEntity;
    private ComingSoon comingSoon;
    private InThreatEntity inThreatEntity;
    private String[] title;

    public OutRecyclerAdapter(Context context,String[] title,
                              UsBoxEntity usBoxEntity,
                              ComingSoon comingSoon,
                              InThreatEntity inThreatEntity) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.title = title;
        this.usBoxEntity = usBoxEntity;
        this.comingSoon = comingSoon;
        this.inThreatEntity = inThreatEntity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.menu_movie,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (position == 0){
            holder.tvHotmovie.setText(title[position]);

        }else if (position == 1){
            holder.tvHotmovie.setText(title[position]);

        }else {
            holder.tvHotmovie.setText(title[position]);

        }

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
