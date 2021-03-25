package com.xu.jetpacklearn.views.factor;

import com.xu.jetpacklearn.base.BaseViewModel;

/**
 * @Author 许剑波
 * 创建时间：2021/3/25  10:13
 * 类的功能：
 */
public class FactorItemViewModel extends BaseViewModel {

    public boolean isChecked;
    public String factorText;

    public FactorItemViewModel(boolean isChecked, String factorText) {
        super();
        this.isChecked = isChecked;
        this.factorText = factorText;
    }


}
