package com.team.rhinoceros.story.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;

import com.team.rhinoceros.story.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2015/11/1.
 */
public class HomeViewPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> mViews;
    private LayoutInflater mInflater;

    public HomeViewPagerAdapter(FragmentManager fm, List<BaseFragment> mViews, LayoutInflater mInflater) {
        super(fm);
        this.mViews = mViews;
        this.mInflater = mInflater;
    }



    @Override
    public Fragment getItem(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mViews.size();
    }
}
