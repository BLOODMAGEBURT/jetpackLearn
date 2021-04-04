package com.xu.jetpacklearn.learn;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * author : xujianbo
 * date : 2021/4/4 7:32 下午
 * description :
 */
public class ColorTextView extends AppCompatTextView {

    Paint paint;

    public ColorTextView(Context context) {
        super(context);
        init();
    }

    public ColorTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 在super之前调用

        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);

        super.onDraw(canvas);
    }

    int lastX = 0;
    int lastY = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 记录触摸点坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                // 计算偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                // 在当前left、top、right、bottom的基础上加上偏移量
                if (getLeft() + offsetX >= 0 && getRight() + offsetX <= ((View) getParent()).getRight()) {
                    layout(getLeft() + offsetX,
                            getTop() + offsetY,
                            getRight() + offsetX,
                            getBottom() + offsetY);
                }


                break;
        }


        return true;
    }
}
