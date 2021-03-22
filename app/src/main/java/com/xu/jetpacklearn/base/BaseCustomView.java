package com.xu.jetpacklearn.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * author : xujianbo
 * date : 2021/3/22 11:36 下午
 * description :
 */
public abstract class BaseCustomView<T extends ViewDataBinding, S extends BaseViewModel> extends LinearLayout implements ICustomView<S> {

    private T dataBinding;
    private S viewModel;

    public BaseCustomView(Context context) {
        super(context);
        init();
    }

    public BaseCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public BaseCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        dataBinding = DataBindingUtil.inflate(inflater, setLayout(), this, false);
        dataBinding.getRoot().setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onRootClicked(v);
            }
        });
        addView(dataBinding.getRoot());
    }


    @Override
    public void setData(S data) {
        viewModel = data;
        setDataToView(data);
        if (dataBinding != null) {
            dataBinding.executePendingBindings();
        }
        onDataUpdated();
    }

    public T getDataBinding() {
        return dataBinding;
    }

    public S getViewModel() {
        return viewModel;
    }

    protected abstract int setLayout();

    protected abstract void onRootClicked(View v);

    protected abstract void setDataToView(S data);

    protected void onDataUpdated() {

    }
}
