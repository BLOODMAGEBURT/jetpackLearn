package com.xu.jetpacklearn.views.settletypeview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.xu.jetpacklearn.R;
import com.xu.jetpacklearn.base.BaseCustomView;
import com.xu.jetpacklearn.databinding.SettleTypeViewBinding;

/**
 * @Author 许剑波
 * 创建时间：2021/3/23  16:48
 * 类的功能：结算方式
 */
public class SettleTypeView extends BaseCustomView<SettleTypeViewBinding, SettleTypeViewModel> {
    public SettleTypeView(Context context) {
        super(context);
    }

    public SettleTypeView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SettleTypeView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int setLayout() {
        return R.layout.settle_type_view;
    }

    @Override
    protected void onRootClicked(View v) {

    }

    @Override
    protected void setDataToView(SettleTypeViewModel data) {
        getDataBinding().setModel(data);
    }
}
