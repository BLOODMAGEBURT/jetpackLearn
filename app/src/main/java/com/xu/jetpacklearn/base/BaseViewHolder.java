package com.xu.jetpacklearn.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

/**
 * author : xujianbo
 * date : 2021/3/22 11:05 下午
 * description :
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    private ICustomView itemView;

    public BaseViewHolder(@NonNull @NotNull ICustomView itemView) {

        super((View) itemView);

        this.itemView = itemView;
    }

    public void bind(BaseViewModel viewModel) {
        itemView.setData(viewModel);
    }

}
