package com.toryang.sampledemo.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.toryang.sampledemo.R;
import com.toryang.sampledemo.entities.movieEntitiy.Movieinfo;
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

    private UsBoxEntity usBoxEntity;
    private Movieinfo movieinfo;

    public GridAdapter(Context context, Movieinfo movieinfo){
        mContext = context ;
        this.movieinfo = movieinfo;
    }
    public GridAdapter(Context context,UsBoxEntity usBoxEntity){
        mContext = context;
        this.usBoxEntity = usBoxEntity;
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
        }else{
//            App.getPicasso().with(mContext).load(top250Entity.getSubjects().get(position).getImages().getLarge()).into(holder.imageView);
            holder.simpleDraweeView.setImageURI(getUri(movieinfo.getSubjects().get(position).getImages().getLarge()));
            holder.textView.setText(movieinfo.getSubjects().get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return usBoxEntity!=null ? usBoxEntity.getSubjects().size():movieinfo.getSubjects().size();
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
