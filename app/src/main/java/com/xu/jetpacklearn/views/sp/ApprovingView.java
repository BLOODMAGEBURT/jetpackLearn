package com.xu.jetpacklearn.views.sp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.xu.jetpacklearn.R;
import com.xu.jetpacklearn.base.BaseCustomView;
import com.xu.jetpacklearn.databinding.ApprovingViewBinding;

/**
 * @Author 许剑波
 * 创建时间：2021/3/25  14:53
 * 类的功能：
 */
public class ApprovingView extends BaseCustomView<ApprovingViewBinding, ApprovingViewModel> {
    public ApprovingView(Context context) {
        super(context);
    }

    public ApprovingView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ApprovingView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int setLayout() {
        return R.layout.approving_view;
    }

    @Override
    protected void onRootClicked(View v) {

    }

    @Override
    protected void setDataToView(ApprovingViewModel data) {

        getDataBinding().setModel(data);
        getDataBinding().fv.setFactorItemModels(data.factorItemViewModels);
    }
}
