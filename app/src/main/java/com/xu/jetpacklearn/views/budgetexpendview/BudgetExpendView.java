package com.xu.jetpacklearn.views.budgetexpendview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.xu.jetpacklearn.R;
import com.xu.jetpacklearn.base.BaseCustomView;
import com.xu.jetpacklearn.databinding.BudgetExpendViewBinding;

/**
 * author : xujianbo
 * date : 2021/3/23 10:59 下午
 * description :
 */
public class BudgetExpendView extends BaseCustomView<BudgetExpendViewBinding, BudgetExpendViewModel> {
    public BudgetExpendView(Context context) {
        super(context);
    }

    public BudgetExpendView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BudgetExpendView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int setLayout() {
        return R.layout.budget_expend_view;
    }

    @Override
    protected void onRootClicked(View v) {

    }

    @Override
    protected void setDataToView(BudgetExpendViewModel data) {
        getDataBinding().setModel(data);
    }
}
