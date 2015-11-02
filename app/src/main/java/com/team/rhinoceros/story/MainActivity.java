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
public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolBar;
    private ViewPager mViewPager;
    private HomeViewPagerAdapter mViewPagerAdapter;
    private List<BaseFragment> mViews=new ArrayList<BaseFragment>();


    private ImageView mImageViewTitle;
    private TextView mTextViewTitle;
    private ImageButton mImageButtonSearch;
    private ImageButton mImageButtonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initView();
    }

    //初始化View
    private void initView(){

        mViewPager= (ViewPager) findViewById(R.id.viewpager_activity_main);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawerlayout_activity_main);

        mToolBar= (Toolbar) findViewById(R.id.toolbar_activity_main);
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,mToolBar,R.string.drawer_open,R.string.drawer_close){
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



        HomePagerFragment homePagerFragment=new HomePagerFragment();
        TruthFragment truthFragment=new TruthFragment();
        TravelFragment travelFragment=new TravelFragment();
        CreateFragment createFragment=new CreateFragment();
        SecreteFragment secreteFragment=new SecreteFragment();
        mViews.add(homePagerFragment);
        mViews.add(truthFragment);
        mViews.add(createFragment);
        mViews.add(travelFragment);
        mViews.add(secreteFragment);
        mViewPagerAdapter=new HomeViewPagerAdapter(getSupportFragmentManager(),mViews,getLayoutInflater());
        mViewPager.setAdapter(mViewPagerAdapter);




    }



}
