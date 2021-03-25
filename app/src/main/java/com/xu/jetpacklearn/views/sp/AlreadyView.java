package com.xu.jetpacklearn.views.sp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.xu.jetpacklearn.R;
import com.xu.jetpacklearn.base.BaseCustomView;
import com.xu.jetpacklearn.databinding.AlreadyViewBinding;

/**
 * @Author 许剑波
 * 创建时间：2021/3/25  14:30
 * 类的功能： 已审批的View
 */
public class AlreadyView extends BaseCustomView<AlreadyViewBinding, AlreadyViewModel> {
    public AlreadyView(Context context) {
        super(context);
    }

    public AlreadyView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AlreadyView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int setLayout() {
        return R.layout.already_view;
    }

    @Override
    protected void onRootClicked(View v) {

    }

    @Override
    protected void setDataToView(AlreadyViewModel data) {
        getDataBinding().setModel(data);
    }
}
