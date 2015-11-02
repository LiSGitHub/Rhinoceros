package com.team.rhinoceros.story.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.team.rhinoceros.story.BaseFragment;
import com.team.rhinoceros.story.R;

import java.util.List;

/**
 * Created by Administrator on 2015/11/1.
 */
public class HomePagerFragment extends BaseFragment  {
    private View mView;


    private PullToRefreshScrollView mPullRefreshHomePager;
    private ScrollView mScrollView;

    private ViewPager mViewpager;
    private List<View> mViewsHomepager;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.activity_homepager,null);
        initview();

        return mView;
    }


   private void initview(){
       //下拉刷新
       mPullRefreshHomePager= (PullToRefreshScrollView) mView.findViewById(R.id.pull_refresh_scrollview_homepager);
       mPullRefreshHomePager.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {

           @Override
           public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
               new GetDataTask().execute();
           }
       });

       mScrollView = mPullRefreshHomePager.getRefreshableView();
   }

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


}
