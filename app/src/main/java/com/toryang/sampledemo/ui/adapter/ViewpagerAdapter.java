package com.toryang.sampledemo.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toryang on 16/4/26.
 */
public class ViewpagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments = new ArrayList<Fragment>();
    private List<String> mFragmentTitles = new ArrayList<String>();

    public ViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragments(Fragment fragment,String titles){
        mFragments.add(fragment);
        mFragmentTitles.add(titles);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }
}
