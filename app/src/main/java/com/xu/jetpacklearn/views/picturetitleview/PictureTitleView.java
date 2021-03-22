package com.xu.jetpacklearn.views.picturetitleview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.xu.jetpacklearn.R;
import com.xu.jetpacklearn.base.BaseCustomView;
import com.xu.jetpacklearn.base.ICustomView;
import com.xu.jetpacklearn.databinding.PictureTitleViewBinding;

/**
 * author : xujianbo
 * date : 2021/3/22 9:54 下午
 * description :
 */
public class PictureTitleView extends BaseCustomView<PictureTitleViewBinding, PictureTitleViewModel> {


    public PictureTitleView(Context context) {
        super(context);
    }

    public PictureTitleView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PictureTitleView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PictureTitleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected int setLayout() {
        return R.layout.picture_title_view;
    }

    @Override
    protected void onRootClicked(View v) {
        Toast.makeText(getContext(), getViewModel().link, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void setDataToView(PictureTitleViewModel data) {
        getDataBinding().setModel(data);
    }
}
