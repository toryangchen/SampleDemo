package com.toryang.sampledemo.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.toryang.sampledemo.App;
import com.toryang.sampledemo.R;
import com.toryang.sampledemo.entities.comingSoon.ComingSoon;
import com.toryang.sampledemo.entities.inthreat.InThreatEntity;
import com.toryang.sampledemo.entities.top250.Top250Entity;
import com.toryang.sampledemo.entities.usbox.UsBoxEntity;
import com.toryang.sampledemo.utils.Log;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by toryang on 5/24/16.
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    Log log = Log.YLog();
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    private UsBoxEntity usBoxEntity;
    private ComingSoon comingSoon;
    private InThreatEntity inThreatEntity;
    private Top250Entity top250Entity;

    public GridAdapter(Context context,UsBoxEntity usBoxEntity){
        mContext = context;
        this.usBoxEntity = usBoxEntity;
    }

    public GridAdapter(Context context,ComingSoon comingSoon){
        mContext = context;
        this.comingSoon = comingSoon;
    }

    public GridAdapter(Context context,InThreatEntity inThreatEntity){
        mContext = context;
        this.inThreatEntity = inThreatEntity;
    }

    public GridAdapter(Context context, Top250Entity top250Entity){
        mContext = context;
        this.top250Entity = top250Entity;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,null);
        GridViewHolder gridViewHolder = new GridViewHolder(view);
        return gridViewHolder;
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
//        log.d(position);
        if (usBoxEntity !=null){
//            App.getPicasso().with(mContext).load(usBoxEntity.getSubjects().get(position).getSubject().getImages().getLarge()).into(holder.imageView);
            holder.simpleDraweeView.setImageURI(getUri(usBoxEntity.getSubjects().get(position).getSubject().getImages().getLarge()));
            holder.textView.setText(usBoxEntity.getSubjects().get(position).getSubject().getTitle());
        }else if (comingSoon != null){
//            App.getPicasso().with(mContext).load(comingSoon.getSubjects().get(position).getImages().getLarge()).into(holder.imageView);
            holder.simpleDraweeView.setImageURI(getUri(comingSoon.getSubjects().get(position).getImages().getLarge()));
            holder.textView.setText(comingSoon.getSubjects().get(position).getTitle());
        }else if (inThreatEntity != null){
//            App.getPicasso().with(mContext).load(inThreatEntity.getSubjects().get(position).getImages().getLarge()).into(holder.imageView);
            holder.simpleDraweeView.setImageURI(getUri(inThreatEntity.getSubjects().get(position).getImages().getLarge()));
            holder.textView.setText(inThreatEntity.getSubjects().get(position).getTitle());
        }else{
//            App.getPicasso().with(mContext).load(top250Entity.getSubjects().get(position).getImages().getLarge()).into(holder.imageView);
            holder.simpleDraweeView.setImageURI(getUri(top250Entity.getSubjects().get(position).getImages().getLarge()));
            holder.textView.setText(top250Entity.getSubjects().get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return usBoxEntity!=null ? usBoxEntity.getSubjects().size():
                (comingSoon != null?comingSoon.getSubjects().size():
                        (inThreatEntity!=null?inThreatEntity.getSubjects().size():top250Entity.getSubjects().size()));
    }

    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.rl_cardview)
        CardView mRlCardview;
        @BindView(R.id.image_movie)
        SimpleDraweeView simpleDraweeView;
        @BindView(R.id.tv_movie_name)
        TextView textView;

        public GridViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.rl_cardview){
                log.d(getPosition());
            }

        }
    }

    private Uri getUri(String uri){
        return Uri.parse(uri);
    }
}
