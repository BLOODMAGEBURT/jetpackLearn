package com.xu.jetpacklearn.views.sp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.xu.jetpacklearn.R;
import com.xu.jetpacklearn.base.BaseCustomView;
import com.xu.jetpacklearn.databinding.WaitingViewBinding;

/**
 * @Author 许剑波
 * 创建时间：2021/3/25  15:01
 * 类的功能：
 */
public class WaitingView extends BaseCustomView<WaitingViewBinding, WaitingViewModel> {
    public WaitingView(Context context) {
        super(context);
    }

    public WaitingView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WaitingView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int setLayout() {
        return R.layout.waiting_view;
    }

    @Override
    protected void onRootClicked(View v) {

    }

    @Override
    protected void setDataToView(WaitingViewModel data) {
        getDataBinding().setModel(data);
    }
}
