package com.xu.jetpacklearn.views.budgetview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.xu.jetpacklearn.R;
import com.xu.jetpacklearn.base.BaseCustomView;
import com.xu.jetpacklearn.base.BaseViewModel;
import com.xu.jetpacklearn.databinding.BudgetViewBinding;

/**
 * @Author 许剑波
 * 创建时间：2021/3/23  16:09
 * 类的功能：预算项目
 */
public class BudgetView extends BaseCustomView<BudgetViewBinding, BudgetViewModel> {
    public BudgetView(Context context) {
        super(context);
    }

    public BudgetView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BudgetView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BudgetView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int setLayout() {
        return R.layout.budget_view;
    }

    @Override
    protected void onRootClicked(View v) {

    }

    @Override
    protected void setDataToView(BudgetViewModel data) {
        getDataBinding().setModel(data);
    }
}
