package com.xu.jetpacklearn.views.factor;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.xu.jetpacklearn.R;
import com.xu.jetpacklearn.base.BaseCustomView;
import com.xu.jetpacklearn.databinding.FactorItemViewBinding;

/**
 * @Author 许剑波
 * 创建时间：2021/3/25  10:05
 * 类的功能：
 */
public class FactorItemView extends BaseCustomView<FactorItemViewBinding, FactorItemViewModel> {
    public FactorItemView(Context context) {
        super(context);
    }

    public FactorItemView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FactorItemView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int setLayout() {
        return R.layout.factor_item_view;
    }

    @Override
    protected void onRootClicked(View v) {
    }

    @Override
    protected void setDataToView(FactorItemViewModel data) {
        getDataBinding().setModel(data);
    }
}
