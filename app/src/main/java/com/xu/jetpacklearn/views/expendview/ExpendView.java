package com.xu.jetpacklearn.views.expendview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.xu.jetpacklearn.R;
import com.xu.jetpacklearn.base.BaseCustomView;
import com.xu.jetpacklearn.databinding.ExpendViewBinding;

/**
 * @Author 许剑波
 * 创建时间：2021/3/23  16:24
 * 类的功能：支出事项
 */
public class ExpendView extends BaseCustomView<ExpendViewBinding, ExpendViewModel> {

    public ExpendView(Context context) {
        super(context);
    }

    public ExpendView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpendView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int setLayout() {
        return R.layout.expend_view;
    }

    @Override
    protected void onRootClicked(View v) {

    }

    @Override
    protected void setDataToView(ExpendViewModel data) {
        getDataBinding().setModel(data);
    }
}
