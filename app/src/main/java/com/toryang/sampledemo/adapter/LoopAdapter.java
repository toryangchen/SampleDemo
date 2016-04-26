package com.toryang.sampledemo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.toryang.sampledemo.R;

/**
 * Created by toryang on 16/4/26.
 */
public class LoopAdapter extends LoopPagerAdapter {
    private int[] imgs = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5
    };

    public LoopAdapter(RollPagerView viewPager) {
        super(viewPager);
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setImageResource(imgs[position]);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    protected int getRealCount() {
        return imgs.length;
    }
}
