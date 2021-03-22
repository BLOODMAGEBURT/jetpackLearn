package com.xu.jetpacklearn.views.titleview;

import android.content.Context;
import android.database.DatabaseUtils;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.xu.jetpacklearn.R;
import com.xu.jetpacklearn.base.BaseCustomView;
import com.xu.jetpacklearn.base.ICustomView;
import com.xu.jetpacklearn.databinding.TitleViewBinding;

/**
 * author : xujianbo
 * date : 2021/3/22 9:38 下午
 * description :
 */
public class TitleView extends BaseCustomView<TitleViewBinding, TitleViewViewModel> {


    public TitleView(Context context) {
        super(context);
    }

    public TitleView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TitleView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int setLayout() {
        return R.layout.title_view;
    }

    @Override
    protected void onRootClicked(View v) {
        Toast.makeText(getContext(), getViewModel().link, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void setDataToView(TitleViewViewModel data) {
        getDataBinding().setModel(data);
    }
}
