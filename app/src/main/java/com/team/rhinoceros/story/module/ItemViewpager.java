package com.team.rhinoceros.story.module;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2015/11/2.
 */
public class ItemViewpager extends ViewPager {

    /**
     * 触摸时按下的点
     **/
    PointF downP = new PointF();
    /**
     * 触摸时当前的点
     **/
    PointF curP = new PointF();
    OnSingleTouchListener onSingleTouchListener;

    public ItemViewpager(Context context) {
        super(context);
    }

    public ItemViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //当拦截触摸事件到达此位置的时候，返回true，
        //说明将onTouch拦截在此控件，进而执行此控件的onTouchEvent
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downP.x = ev.getX();
                downP.y = ev.getY();
                //此句代码是为了通知他的父ViewPager现在进行的是本控件的操作，不要对我的操作进行干扰
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                curP.x = ev.getX();
                curP.y = ev.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_UP:
                if (downP.x == curP.x && downP.y == curP.y) {
                    onSingleTouch();
                    return true;
                }
                break;
        }

        return super.onTouchEvent(ev);
    }

    /**
     * 　　 * 单击
     *
     */
    public void onSingleTouch() {
        if (onSingleTouchListener != null) {

            onSingleTouchListener.onSingleTouch();
        }
    }

    /**
     * 　　 * 创建点击事件接口
     * 　　 * @author wanpg
     * 　　 *
     *
     */
    public interface OnSingleTouchListener {
        public void onSingleTouch();
    }


    public void setOnSingleTouchListener(OnSingleTouchListener onSingleTouchListener) {
        this.onSingleTouchListener = onSingleTouchListener;
    }


}
