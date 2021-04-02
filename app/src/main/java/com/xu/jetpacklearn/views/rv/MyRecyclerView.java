package com.xu.jetpacklearn.views.rv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * author : xujianbo
 * date : 2021/4/1 8:27 上午
 * description : 自定义RecyclerView
 */
public class MyRecyclerView extends ViewGroup {
    public MyRecyclerView(Context context) {
        super(context);
        init();
    }

    public MyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {



    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    interface Adapter {
        View onCreateViewHolder(int position, View convertView, ViewGroup parent);

        View onBindViewHolder(int position, View convertView, ViewGroup parent);

        int getItemViewType(int position);

        int getViewTypeCount();

        int getCount();

        int getHeight(int position);

    }

}
