package com.xu.jetpacklearn.views.basicinfoview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.xu.jetpacklearn.R;
import com.xu.jetpacklearn.base.BaseCustomView;
import com.xu.jetpacklearn.base.BaseViewModel;
import com.xu.jetpacklearn.databinding.BasicInfoViewBinding;

/**
 * @Author 许剑波
 * 创建时间：2021/3/23  15:43
 * 类的功能：基本信息
 */
public class BasicInfoView extends BaseCustomView<BasicInfoViewBinding, BasicInfoViewModel>{

    public BasicInfoView(Context context) {
        super(context);
    }

    public BasicInfoView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BasicInfoView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BasicInfoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int setLayout() {
        return R.layout.basic_info_view;
    }

    @Override
    protected void onRootClicked(View v) {

    }

    @Override
    protected void setDataToView(BasicInfoViewModel data) {
        getDataBinding().setModel(data);
    }
}
