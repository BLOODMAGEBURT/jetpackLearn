package com.xu.jetpacklearn.views.factor;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.xu.jetpacklearn.utils.Utils;

import java.util.List;

/**
 * @Author 许剑波
 * 创建时间：2021/3/25  10:05
 * 类的功能：
 */
public class FactorView extends LinearLayout {
    private FactorItemView headerView;

    public FactorView(Context context) {
        super(context);
        init();
    }


    public FactorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FactorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {

        // 先创建 最上面的一条全选
        headerView = new FactorItemView(getContext());
        headerView.getDataBinding().ckFactorChoose.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("xu", "header选择状态：" + headerView.getDataBinding().ckFactorChoose.isChecked());

                // 如果是选中状态，就将所有子view选中
                if (headerView.getDataBinding().ckFactorChoose.isChecked()) {
                    setAllChecked(true);
                } else {
                    // 如果是未选中状态， 将所有子view取消选中
                    setAllChecked(false);
                }

            }
        });
        headerView.setData(new FactorItemViewModel(false, "审批要素(请确认审批责任)"));


        addView(headerView);

    }

    public void setFactorItemModels(List<FactorItemViewModel> factorItemModels) {


        // 创建 下方的选项
        for (FactorItemViewModel factorItemModel : factorItemModels) {
            FactorItemView itemView = new FactorItemView(getContext());

            itemView.setData(new FactorItemViewModel(factorItemModel.isChecked, factorItemModel.factorText));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMarginStart(Utils.dip2px(getContext(), 20));

            itemView.getDataBinding().ckFactorChoose.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("xu", "子view选中状态：" + itemView.getDataBinding().ckFactorChoose.isChecked());

                    if (itemView.getViewModel().isChecked) {
                        // 判断是不是所有子view 都选中了
                        if (isAllChecked()) {
                            // 如果子view都选中了， 则选中headerView
                            headerView.getDataBinding().ckFactorChoose.setChecked(true);
                        }
                    } else {
                        // 如果headerView被选中，则取消选中
                        if (headerView.getViewModel().isChecked) {
                            headerView.getDataBinding().ckFactorChoose.setChecked(false);
                        }
                    }
                }
            });

            addView(itemView, params);
        }

    }

    //设置 子view全选
    public void setAllChecked(boolean allChecked) {

        for (int i = 0; i < getChildCount(); i++) {
            ((FactorItemView) getChildAt(i)).getDataBinding().ckFactorChoose.setChecked(allChecked);
        }
    }

    // 判断是不是所有 子view都选中了
    public boolean isAllChecked() {
        for (int i = 1; i < getChildCount(); i++) {

            if (!((FactorItemView) getChildAt(i)).getViewModel().isChecked) {
                // 只要有一个未选中，返回false
                return false;
            }
        }
        return true;
    }


}
