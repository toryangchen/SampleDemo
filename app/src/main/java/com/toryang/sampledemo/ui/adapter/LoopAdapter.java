package com.toryang.sampledemo.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.toryang.sampledemo.R;
import com.toryang.sampledemo.common.OkhttpUtil;
import com.toryang.sampledemo.utils.Log;

import java.io.IOException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by toryang on 16/4/26.
 */
public class LoopAdapter extends LoopPagerAdapter {
    Log log = Log.YLog();
    private int[] imgs = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5
    };
    private String[] imageUri;
    Context context;

    public LoopAdapter(Context context,RollPagerView viewPager, String[] imageUri) {
        super(viewPager);
        this.context = context;
        this.imageUri = imageUri;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setImageResource(imgs[position]);
//        log.d(imageUri[position]);
//        downLoadImage(new OkhttpUtil(imageUri[position]).downloadDrawble);
//        view.setImageDrawable(downLoadImage(new OkhttpUtil(imageUri[position]).downloadDrawble));
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    protected int getRealCount() {
        return imageUri.length;
    }


    public Drawable downLoadImage(Observable<Bitmap> observable){
        final Drawable[] drawables = {null};
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Bitmap>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        log.e(e.toString());
                    }

                    @Override
                    public void onNext(Bitmap bitmap) {
                        Drawable drawable = new BitmapDrawable(context.getResources(),bitmap);
                        drawables[0] =drawable;
                    }
                });

        return drawables[0];
    }

}
