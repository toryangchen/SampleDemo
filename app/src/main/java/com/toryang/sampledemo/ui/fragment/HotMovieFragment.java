package com.toryang.sampledemo.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.toryang.sampledemo.R;
import com.toryang.sampledemo.entities.movieEntitiy.Movieinfo;
import com.toryang.sampledemo.entities.usbox.UsBoxEntity;
import com.toryang.sampledemo.loading.MyLoading;
import com.toryang.sampledemo.presenter.HotMoviePresenterImpl;
import com.toryang.sampledemo.ui.BaseFragment;
import com.toryang.sampledemo.ui.adapter.OutRecyclerAdapter;
import com.toryang.sampledemo.ui.view.DataView;
import com.toryang.sampledemo.utils.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by toryang on 16/4/26.
 */
public class HotMovieFragment extends BaseFragment implements DataView {

    @BindView(R.id.recycler_movie)
    RecyclerView recyclerMovie;
    @BindView(R.id.loading)
    MyLoading loading;

    @BindArray(R.array.movie_title)
    String[] title;


    private HotMoviePresenterImpl presenter;
    private OutRecyclerAdapter mAdapter;

    List<Object> lists = new ArrayList<>();
    Log log = Log.YLog();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotmovie, container, false);
        ButterKnife.bind(this, view);
        operateView();
//        App.getPicasso().with(getActivity()).load("http://i.imgur.com/DvpvklR.png").into(imageView);
        return view;
    }

    public void operateView() {
        setMyLoading(loading);
        presenter = new HotMoviePresenterImpl(getActivity());
        presenter.attachView(this);
        presenter.loadData();

        //        presenter.loadHotMovieWithVolley();
//        mRollViewPager.setPlayDelay(1000);
//        mRollViewPager.setAnimationDurtion(500);
//        mRollViewPager.setAdapter(new LoopAdapter(getActivity(),mRollViewPager,imageUri));
//        mRollViewPager.setHintView(new IconHintView(getContext(), R.drawable.point_focus, R.drawable.point_normal));
        recyclerMovie.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }

    /**
     * Presenter 的回调接口，用于更新UI
     */
    @Override
    public void loadData(UsBoxEntity usBoxEntity, Movieinfo comingSoon, Movieinfo inThreatEntity) {
//        log.d(usBoxEntity.getTitle()+":"+comingSoon.getTitle()+":"+inThreatEntity.getTitle());
//        loading.stop();
        lists.add(0,inThreatEntity);
        lists.add(1,comingSoon);
        lists.add(2,usBoxEntity);
        mAdapter = new OutRecyclerAdapter(getActivity(),title,lists);
//        imageUri[0] = usBoxEntity.getSubjects().get(0).getSubject().getImages().getLarge();
        recyclerMovie.setAdapter(mAdapter);

    }


//    public void downLoadImage(Observable<Bitmap> observable){
//        observable.subscribeOn(Schedulers.io())
//                .onBackpressureBuffer()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Bitmap>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        log.e(e.toString());
//                    }
//
//                    @Override
//                    public void onNext(Bitmap s) {
////                        imageView.setImageDrawable(new BitmapDrawable(getResources(),s));
//                        log.d(s);
//                    }
//                });
//    }



}
