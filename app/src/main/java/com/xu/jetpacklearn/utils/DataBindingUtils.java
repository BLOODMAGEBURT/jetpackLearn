package com.xu.jetpacklearn.utils;

import androidx.databinding.InverseMethod;

/**
 * @Author 许剑波
 * 创建时间：2021/3/23  15:57
 * 类的功能：
 */
public class DataBindingUtils {

    @InverseMethod("convertDoubleToString")
    public static double convertStringToDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String convertDoubleToString(double value) {
        return String.valueOf(value);
    }

}
