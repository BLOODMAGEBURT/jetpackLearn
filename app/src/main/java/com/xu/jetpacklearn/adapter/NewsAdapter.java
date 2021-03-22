package com.xu.jetpacklearn.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xu.jetpacklearn.base.BaseViewHolder;
import com.xu.jetpacklearn.base.BaseViewModel;
import com.xu.jetpacklearn.views.picturetitleview.PictureTitleView;
import com.xu.jetpacklearn.views.titleview.TitleView;
import com.xu.jetpacklearn.views.titleview.TitleViewViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * author : xujianbo
 * date : 2021/3/22 11:06 下午
 * description :
 */
public class NewsAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    private List<BaseViewModel> items;
    private final int PICTURE_TITLE_TYPE = 1;
    private final int TITLE_TYPE = 2;

    public void setData(List<BaseViewModel> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        if (viewType == TITLE_TYPE) {
            TitleView titleView = new TitleView(parent.getContext());
            return new BaseViewHolder(titleView);
        }

        if (viewType == PICTURE_TITLE_TYPE) {
            PictureTitleView pictureTitleView = new PictureTitleView(parent.getContext());
            return new BaseViewHolder(pictureTitleView);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BaseViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof TitleViewViewModel) {
            return TITLE_TYPE;
        } else {
            return PICTURE_TITLE_TYPE;
        }
    }

    @Override
    public int getItemCount() {

        return items == null ? 0 : items.size();
    }
}
