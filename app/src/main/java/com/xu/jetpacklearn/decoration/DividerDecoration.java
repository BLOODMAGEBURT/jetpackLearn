package com.xu.jetpacklearn.decoration;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

/**
 * author : xujianbo
 * date : 2021/3/23 11:55 下午
 * description :
 */
public class DividerDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(@NonNull @NotNull Rect outRect, @NonNull @NotNull View view, @NonNull @NotNull RecyclerView parent, @NonNull @NotNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        //如果不是第一个，则设置top的值。
        if (parent.getChildAdapterPosition(view) != 0) {
            // 硬编码为10
            outRect.top = 20;
        }

    }
}
