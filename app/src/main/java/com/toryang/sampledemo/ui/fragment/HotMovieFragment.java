package com.toryang.sampledemo.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.IconHintView;
import com.toryang.sampledemo.R;
import com.toryang.sampledemo.common.OkhttpUtil;
import com.toryang.sampledemo.model.entities.comingSoon.ComingSoon;
import com.toryang.sampledemo.model.entities.inthreat.InThreatEntity;
import com.toryang.sampledemo.model.entities.usbox.UsBoxEntity;
import com.toryang.sampledemo.presenter.HotMoviePresenterImpl;
import com.toryang.sampledemo.ui.BaseFragment;
import com.toryang.sampledemo.ui.adapter.LoopAdapter;
import com.toryang.sampledemo.ui.adapter.OutRecyclerAdapter;
import com.toryang.sampledemo.ui.view.DataView;
import com.toryang.sampledemo.utils.Log;

import java.io.IOException;

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

    @BindView(R.id.roll_view_pager)
    RollPagerView mRollViewPager;
    @BindView(R.id.recycler_movie)
    RecyclerView recyclerMovie;
    @BindArray(R.array.movie_title)
    String[] title;

    String[] imageUri = new String[3];
    private HotMoviePresenterImpl presenter;
    private OutRecyclerAdapter mAdapter;

    Log log = Log.YLog();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HotMoviePresenterImpl(getActivity());
        presenter.attachView(this);
        presenter.loadData();
//        presenter.loadHotMovieWithVolley();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotmovie, container, false);
        ButterKnife.bind(this, view);
        operateView();
        return view;
    }

    public void operateView() {
        mRollViewPager.setPlayDelay(1000);
        mRollViewPager.setAnimationDurtion(500);
        mRollViewPager.setAdapter(new LoopAdapter(getActivity(),mRollViewPager,imageUri));
        mRollViewPager.setHintView(new IconHintView(getContext(), R.drawable.point_focus, R.drawable.point_normal));
        recyclerMovie.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }

    /**
     * Presenter 的回调接口，用于更新UI
     */

    @Override
    public void refresh(UsBoxEntity usBoxEntity) {


    }

    @Override
    public void loadMore(UsBoxEntity usBoxEntity) {

    }

    @Override
    public void loadData(UsBoxEntity usBoxEntity, ComingSoon comingSoon, InThreatEntity inThreatEntity) {
        log.d(usBoxEntity.getTitle()+":"+comingSoon.getTitle()+":"+inThreatEntity.getTitle());
        mAdapter = new OutRecyclerAdapter(getActivity(),title,usBoxEntity,comingSoon,inThreatEntity);
//        imageUri[0] = usBoxEntity.getSubjects().get(0).getSubject().getImages().getLarge();
//        imageUri[1] = comingSoon.getSubjects().get(0).getImages().getLarge();
//        imageUri[2] = inThreatEntity.getSubjects().get(0).getImages().getLarge();
//        downLoadImage(new OkhttpUtil(imageUri[0]).downloadDrawble);

        recyclerMovie.setAdapter(mAdapter);
    }

    public void downLoadFile(Observable<String> observable){
        observable.subscribeOn(Schedulers.io())
                .onBackpressureBuffer()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        log.e(e.toString());
                    }

                    @Override
                    public void onNext(String s) {


                        log.d(s);
                    }
                });
    }



}
