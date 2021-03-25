package com.xu.jetpacklearn.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xu.jetpacklearn.base.BaseViewHolder;
import com.xu.jetpacklearn.base.BaseViewModel;
import com.xu.jetpacklearn.views.sp.AlreadyView;
import com.xu.jetpacklearn.views.sp.AlreadyViewModel;
import com.xu.jetpacklearn.views.sp.ApprovingView;
import com.xu.jetpacklearn.views.sp.ApprovingViewModel;
import com.xu.jetpacklearn.views.sp.WaitingView;
import com.xu.jetpacklearn.views.sp.WaitingViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @Author 许剑波
 * 创建时间：2021/3/25  15:28
 * 类的功能：
 */
public class ApproveAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private final int ALREADY_TYPE = 1;   // 已审批
    private final int APPROVING_TYPE = 2; // 正在审批
    private final int WAITING_TYPE = 3;   // 未审批

    private List<BaseViewModel> items;

    public void setData(List<BaseViewModel> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        if (viewType == ALREADY_TYPE) {
            return new BaseViewHolder(new AlreadyView(parent.getContext()));
        } else if (viewType == APPROVING_TYPE) {
            return new BaseViewHolder(new ApprovingView(parent.getContext()));
        } else {
            return new BaseViewHolder(new WaitingView(parent.getContext()));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BaseViewHolder holder, int position) {
        holder.bind(items.get(position));
    }


    @Override
    public int getItemViewType(int position) {

        if (items.get(position) instanceof AlreadyViewModel) {
            return ALREADY_TYPE;
        } else if (items.get(position) instanceof ApprovingViewModel) {
            return APPROVING_TYPE;
        } else if (items.get(position) instanceof WaitingViewModel) {
            return WAITING_TYPE;
        }

        return 0;
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }
}
