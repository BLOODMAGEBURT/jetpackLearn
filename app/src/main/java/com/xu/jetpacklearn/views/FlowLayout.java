package com.xu.jetpacklearn.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * author : xujianbo
 * date : 2021/3/30 9:55 下午
 * description :
 */
public class FlowLayout extends ViewGroup {

    List<View> lineViews = new ArrayList<>();
    int horizontalPadding = 0;
    int verticalPadding = 0;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FlowLayout(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int selfWidth = MeasureSpec.getSize(widthMeasureSpec); // 参考宽度
        int selfHeight = MeasureSpec.getSize(heightMeasureSpec); // 参考高度

        int requiredWidth = 0; // group 需要的宽
        int requiredHeight = 0; // group 需要的高

        int lineWidthUsed = 0;
        int lineHeight = 0;

        // 先计量子类
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);

            LayoutParams childLayoutParams = child.getLayoutParams();

            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, childLayoutParams.width);
            int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, childLayoutParams.height);
            // 测量
            child.measure(childWidthMeasureSpec, childHeightMeasureSpec);

            // 获取子view的测量宽度和高度
            int childMeasuredWidth = child.getMeasuredWidth();
            int childMeasuredHeight = child.getMeasuredHeight();


            if (lineWidthUsed + childMeasuredWidth + horizontalPadding >= selfWidth) {
                // 需要换行
                lineViews.clear();

                // 计算宽高
                requiredWidth = Math.max(requiredWidth, lineWidthUsed + horizontalPadding);
                requiredHeight = requiredHeight + lineHeight + verticalPadding;

                // 重置
                lineWidthUsed = 0;
            }


            lineViews.add(child);
            lineWidthUsed = lineWidthUsed + childMeasuredWidth;
            lineHeight = Math.max(lineHeight, childMeasuredHeight);

        }

        // 再测量父类

        int measuredWidth = 0;
        int measureHeight = 0;

        setMeasuredDimension(measuredWidth, measureHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
