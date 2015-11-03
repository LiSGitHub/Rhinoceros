package com.team.rhinoceros.story.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2015/11/2.
 */
public class ItemViewPagerAdapter extends PagerAdapter {
    private List<View> mViewsItemHomePager;


    public ItemViewPagerAdapter( List<View> mViewsItemHomePager) {

        this.mViewsItemHomePager = mViewsItemHomePager;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=mViewsItemHomePager.get(position);
        container.addView(view);
        return view;


    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(mViewsItemHomePager.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public int getCount() {
        return mViewsItemHomePager.size();
    }


}
