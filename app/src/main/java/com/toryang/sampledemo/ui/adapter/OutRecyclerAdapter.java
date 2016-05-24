package com.toryang.sampledemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.toryang.sampledemo.App;
import com.toryang.sampledemo.R;
import com.toryang.sampledemo.entities.comingSoon.ComingSoon;
import com.toryang.sampledemo.entities.inthreat.InThreatEntity;
import com.toryang.sampledemo.entities.usbox.UsBoxEntity;
import com.toryang.sampledemo.ui.activity.MovieInfoActivity;
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
            App.getPicasso().with(mContext).load(inThreatEntity.getSubjects().get(0).getImages().getLarge()).into(holder.imagePicOne);
            App.getPicasso().with(mContext).load(inThreatEntity.getSubjects().get(1).getImages().getLarge()).into(holder.imagePicTwo);
            App.getPicasso().with(mContext).load(inThreatEntity.getSubjects().get(2).getImages().getLarge()).into(holder.imagePicThree);
            holder.tvMovieNameOne.setText(inThreatEntity.getSubjects().get(0).getTitle());
            holder.tvMovieNameTwo.setText(inThreatEntity.getSubjects().get(1).getTitle());
            holder.tvMovieNameThree.setText(inThreatEntity.getSubjects().get(2).getTitle());
        }else if (position == 1){
            holder.tvHotmovie.setText(title[position]);
            App.getPicasso().with(mContext).load(comingSoon.getSubjects().get(0).getImages().getLarge()).into(holder.imagePicOne);
            App.getPicasso().with(mContext).load(comingSoon.getSubjects().get(1).getImages().getLarge()).into(holder.imagePicTwo);
            App.getPicasso().with(mContext).load(comingSoon.getSubjects().get(2).getImages().getLarge()).into(holder.imagePicThree);
            holder.tvMovieNameOne.setText(comingSoon.getSubjects().get(0).getTitle());
            holder.tvMovieNameTwo.setText(comingSoon.getSubjects().get(1).getTitle());
            holder.tvMovieNameThree.setText(comingSoon.getSubjects().get(2).getTitle());
        }else {
            holder.tvHotmovie.setText(title[position]);
            App.getPicasso().with(mContext).load(usBoxEntity.getSubjects().get(0).getSubject().getImages().getLarge()).into(holder.imagePicOne);
            App.getPicasso().with(mContext).load(usBoxEntity.getSubjects().get(1).getSubject().getImages().getLarge()).into(holder.imagePicTwo);
            App.getPicasso().with(mContext).load(usBoxEntity.getSubjects().get(2).getSubject().getImages().getLarge()).into(holder.imagePicThree);
            holder.tvMovieNameOne.setText(usBoxEntity.getSubjects().get(0).getSubject().getTitle());
            holder.tvMovieNameTwo.setText(usBoxEntity.getSubjects().get(1).getSubject().getTitle());
            holder.tvMovieNameThree.setText(usBoxEntity.getSubjects().get(2).getSubject().getTitle());
        }
        MyClickListener myClickListener = new MyClickListener(position);
        holder.mLoadMore.setOnClickListener(myClickListener);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class MyClickListener implements View.OnClickListener{
        int position;
        MyClickListener(int position){
            this.position = position;
        }
        @Override
        public void onClick(View v) {
            if (position == 0){
                if (v.getId() == R.id.load_more){
                    log.d(position);
                    MovieInfoActivity.startActivity(mContext,inThreatEntity);
                }

            }else if (position == 1){
                if (v.getId() == R.id.load_more){
                    log.d(position);
                    MovieInfoActivity.startActivity(mContext,comingSoon);
                }

            }else {
                if (v.getId() == R.id.load_more){
                    log.d(position);
                    MovieInfoActivity.startActivity(mContext,usBoxEntity);
                }
            }
        }


    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.load_more)
        RelativeLayout mLoadMore;
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
