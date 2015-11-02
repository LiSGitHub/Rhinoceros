package com.team.rhinoceros.story;


import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.rhinoceros.story.adapter.HomeViewPagerAdapter;
import com.team.rhinoceros.story.fragment.CreateFragment;
import com.team.rhinoceros.story.fragment.HomePagerFragment;
import com.team.rhinoceros.story.fragment.SecreteFragment;
import com.team.rhinoceros.story.fragment.TravelFragment;
import com.team.rhinoceros.story.fragment.TruthFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolBar;
    private ViewPager mViewPager;
    private HomeViewPagerAdapter mViewPagerAdapter;
    private List<BaseFragment> mViews = new ArrayList<BaseFragment>();

    //头部的搜索按钮、编辑按钮与标题的图标和文本
    private ImageView mImageViewTitle;
    private TextView mTextViewTitle;
    private ImageButton mImageButtonSearch;
    private ImageButton mImageButtonAdd;

    //顶部ViewPager的圆点
    private ImageView mImageViewHomePager;
    private ImageView mImageViewTruthPager;
    private ImageView mImageViewCreatepager;
    private ImageView mImageViewTravelPager;
    private ImageView mImageViewSecretePager;
    //区分选中页数的常量
    private static final int CURRENTHOMEPAGER = 0x0;
    private static final int CURRENTTRUTHPAGER = 0x1;
    private static final int CURRENTCREATEPAGER = 0x2;
    private static final int CURRENTTRAVELPAGER = 0x3;
    private static final int CURRENTSECRETEPAGER = 0x4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initView();
    }

    //初始化View
    private void initView() {
        //头部
        mImageViewTitle= (ImageView) findViewById(R.id.imageview_title_activity_homepager_toolbar);
        mTextViewTitle= (TextView) findViewById(R.id.textview_title_activity_homepager_toolbar);
        mImageButtonSearch= (ImageButton) findViewById(R.id.imagebutton_search_activity_homepager_toolbar);
        mImageButtonAdd= (ImageButton) findViewById(R.id.imagebutton_add_activity_homepager_toolbar);


        mViewPager = (ViewPager) findViewById(R.id.viewpager_activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout_activity_main);

        mToolBar = (Toolbar) findViewById(R.id.toolbar_activity_main);
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
        };

        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);


        //加载fragment
        HomePagerFragment homePagerFragment = new HomePagerFragment();
        TruthFragment truthFragment = new TruthFragment();
        TravelFragment travelFragment = new TravelFragment();
        CreateFragment createFragment = new CreateFragment();
        SecreteFragment secreteFragment = new SecreteFragment();
        mViews.add(homePagerFragment);
        mViews.add(truthFragment);
        mViews.add(createFragment);
        mViews.add(travelFragment);
        mViews.add(secreteFragment);
        mViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager(), mViews, getLayoutInflater());
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.addOnPageChangeListener(this);

        mImageViewHomePager = (ImageView) findViewById(R.id.imageview_top_homeviewpager_main);
        mImageViewTruthPager = (ImageView) findViewById(R.id.imageview_top_truthviewpager_main);
        mImageViewCreatepager = (ImageView) findViewById(R.id.imageview_top_createviewpager_main);
        mImageViewTravelPager = (ImageView) findViewById(R.id.imageview_top_travelviewpager_main);
        mImageViewSecretePager = (ImageView) findViewById(R.id.imageview_top_secreteviewpager_main);


    }

    //ViewPager页面切换的监听事件
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        changeToGrey();
        switch (position) {
            case CURRENTHOMEPAGER:
                mImageViewHomePager.setImageResource(R.drawable.homepager_top_image_pressed);
                mImageViewTitle.setImageResource(R.mipmap.icon_main_action_bar_channel_icon_discovery);
                mTextViewTitle.setText("首页");
                break;
            case CURRENTTRUTHPAGER:
                mImageViewTruthPager.setImageResource(R.drawable.homepager_top_image_pressed);
                mImageViewTitle.setImageResource(R.mipmap.icon_main_action_bar_channel_icon_truth);
                mTextViewTitle.setText("真事");
                break;
            case CURRENTCREATEPAGER:
                mImageViewCreatepager.setImageResource(R.drawable.homepager_top_image_pressed);
                mImageViewTitle.setImageResource(R.mipmap.icon_main_action_bar_channel_icon_create);
                mTextViewTitle.setText("创作");
                break;
            case CURRENTTRAVELPAGER:
                mImageViewTravelPager.setImageResource(R.drawable.homepager_top_image_pressed);
                mImageViewTitle.setImageResource(R.mipmap.icon_main_action_bar_channel_icon_travel);
                mTextViewTitle.setText("游记");
                break;
            case CURRENTSECRETEPAGER:
                mImageViewSecretePager.setImageResource(R.drawable.homepager_top_image_pressed);
                mImageViewTitle.setImageResource(R.mipmap.icon_main_action_bar_channel_icon_secret);
                mTextViewTitle.setText("秘密");
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //将所有的顶部的圆点图片设置为灰色
    private void changeToGrey() {
        mImageViewHomePager.setImageResource(R.drawable.homepager_top_image_normal);
        mImageViewCreatepager.setImageResource(R.drawable.homepager_top_image_normal);
        mImageViewTruthPager.setImageResource(R.drawable.homepager_top_image_normal);
        mImageViewSecretePager.setImageResource(R.drawable.homepager_top_image_normal);
        mImageViewTravelPager.setImageResource(R.drawable.homepager_top_image_normal);

    }


}
