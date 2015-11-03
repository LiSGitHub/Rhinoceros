package com.team.rhinoceros.story.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.team.rhinoceros.story.BaseFragment;
import com.team.rhinoceros.story.R;
import com.team.rhinoceros.story.adapter.ItemViewPagerAdapter;
import com.team.rhinoceros.story.module.ItemViewpager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/1.
 */
public class HomePagerFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private View mView;

    private PullToRefreshScrollView mPullRefreshHomePager;
    private ScrollView mScrollView;
    //首页的子ViewPager
    private ItemViewpager mViewpager;
    private List<View> mViewsItemHomepager=new ArrayList<>();
    private ItemViewPagerAdapter mItemAdapter;
    private  View mViewFirst;
    private  View mViewSecond;
    private  View mViewThird;
    private  View mViewForth;

    //判断当前的ItemViewPager
    private static final int ITEMPAGERFIRST=0x0;
    private static final int ITEMPAGERSECOND=0x1;
    private static final int ITEMPAGERTHIRD=0x2;
    private static final int ITEMPAGERFOUR=0x3;
  //ItenmViewPager的圆点的设置
    private ImageView mImageViewCircleFirst;
    private ImageView mImageViewCircleSecond;
    private ImageView mImageViewCircleThird;
    private ImageView mImageViewCircleFour;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.activity_homepager,null);
        initview();
        return mView;
    }


   private void initview(){
       Fresco.initialize(getContext());
       //初始化ItemVIewPager与底部的圆点
       mViewpager= (ItemViewpager) mView.findViewById(R.id.viewpager_homepager);
       mImageViewCircleFirst= (ImageView) mView.findViewById(R.id.imageview_bottomfirst_viewpager_homepager);
       mImageViewCircleSecond= (ImageView) mView.findViewById(R.id.imageview_bottomsecond_viewpager_homepager);
       mImageViewCircleThird= (ImageView) mView.findViewById(R.id.imageview_bottomthird_viewpager_homepager);
       mImageViewCircleFour= (ImageView) mView.findViewById(R.id.imageview_bottomforth_viewpager_homepager);

       //下拉刷新
       mPullRefreshHomePager= (PullToRefreshScrollView) mView.findViewById(R.id.pull_refresh_scrollview_homepager);
       mPullRefreshHomePager.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {

           @Override
           public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
               new GetDataTask().execute();
           }
       });

       mScrollView = mPullRefreshHomePager.getRefreshableView();

       //设置ViewPager
       mViewFirst=getActivity().getLayoutInflater().inflate(R.layout.itemfirst_viewpager_homepager, null);
       mViewSecond=getActivity().getLayoutInflater().inflate(R.layout.itemsecond_viewpager_homepager,null);
       mViewThird=getActivity().getLayoutInflater().inflate(R.layout.itemthird_viewpager_homepager,null);
       mViewForth=getActivity().getLayoutInflater().inflate(R.layout.itemforth_viewpager_homepager,null);

       mViewsItemHomepager.add(mViewFirst);
       mViewsItemHomepager.add(mViewSecond);
       mViewsItemHomepager.add(mViewThird);
       mViewsItemHomepager.add(mViewForth);

       mItemAdapter=new ItemViewPagerAdapter(mViewsItemHomepager);
       mViewpager.setAdapter(mItemAdapter);
       mViewpager.addOnPageChangeListener(this);
       //设置ItemViewPager的点击事件监听
       mViewpager.setOnSingleTouchListener(new ItemViewpager.OnSingleTouchListener() {
           @Override
           public void onSingleTouch() {
               int type= mViewpager.getCurrentItem();
               switch (type){
                   case ITEMPAGERFIRST:
                       Toast.makeText(getContext(),"点击了第一个ItemViewPager",Toast.LENGTH_SHORT).show();

                       //点击时打开，第一个连接
//                       Intent  intentfirst=new Intent(getActivity(),FirstPager.class);
//                       startActivity(intentfirst);
                       break;
                   case ITEMPAGERSECOND:
                       Toast.makeText(getContext(),"点击了第二个ItemViewPager",Toast.LENGTH_SHORT).show();
                       //点击时打开第二个连接
                       break;

                   case ITEMPAGERTHIRD:
                       Toast.makeText(getContext(),"点击了第三个ItemViewPager",Toast.LENGTH_SHORT).show();
                       break;
                   case ITEMPAGERFOUR:
                       Toast.makeText(getContext(),"点击了第四个ItemViewPager",Toast.LENGTH_SHORT).show();
                       break;
               }
           }
       });

   }
      //ItemViewpager 的监听
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        changeToGrey();
       switch (position){
           case ITEMPAGERFIRST:
               mImageViewCircleFirst.setImageResource(R.drawable.homepager_bottom_image_pressed);
               break;
           case ITEMPAGERSECOND:
               mImageViewCircleSecond.setImageResource(R.drawable.homepager_bottom_image_pressed);
               break;
           case ITEMPAGERTHIRD:
               mImageViewCircleThird.setImageResource(R.drawable.homepager_bottom_image_pressed);
               break;
           case ITEMPAGERFOUR:
               mImageViewCircleFour.setImageResource(R.drawable.homepager_bottom_image_pressed);
               break;
       }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //刷新数据，更新UI界面
    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(String[] result) {
            // Do some stuff here

            // Call onRefreshComplete when the list has been refreshed.
            mPullRefreshHomePager.onRefreshComplete();

            super.onPostExecute(result);
        }
    }

    private void changeToGrey(){
        mImageViewCircleFirst.setImageResource(R.drawable.homepager_bottom_image_normal);
        mImageViewCircleSecond.setImageResource(R.drawable.homepager_bottom_image_normal);
        mImageViewCircleThird.setImageResource(R.drawable.homepager_bottom_image_normal);
        mImageViewCircleFour.setImageResource(R.drawable.homepager_bottom_image_normal);

    }

}
