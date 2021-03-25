package com.xu.jetpacklearn.views.sp;

import com.xu.jetpacklearn.base.BaseViewModel;
import com.xu.jetpacklearn.views.factor.FactorItemViewModel;

import java.util.List;

/**
 * @Author 许剑波
 * 创建时间：2021/3/25  14:33
 * 类的功能：审批中的viewModel
 */
public class ApprovingViewModel extends BaseViewModel {
    public String orderNum;
    public String processName;

    public String checkUserName;
    public String checkTime;
    public String checkResult;

    public List<FactorItemViewModel> factorItemViewModels; // 审批要素

    public List<String> specialActions; //特殊操作

    public String comment; // 审批意见


}
