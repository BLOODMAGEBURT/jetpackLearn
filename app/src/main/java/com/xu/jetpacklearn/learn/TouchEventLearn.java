package com.xu.jetpacklearn.learn;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * author : xujianbo
 * date : 2021/4/1 11:08 下午
 * description :  事件分发学习
 */
public class TouchEventLearn extends LinearLayout {


    public TouchEventLearn(Context context) {
        super(context);
    }

    public TouchEventLearn(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {


        Log.d("xu", "TouchEventLearn ---------onInterceptTouchEvent");
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d("xu", "TouchEventLearn ---------onTouchEvent");
        return true;
    }


}
