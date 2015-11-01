package com.team.rhinoceros.story.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.rhinoceros.story.BaseFragment;
import com.team.rhinoceros.story.R;

/**
 * Created by Administrator on 2015/11/1.
 */
public class SecreteFragment extends BaseFragment{
    private View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.activity_secrete,null);
        return mView;
    }
}
