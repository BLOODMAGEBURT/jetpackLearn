package com.xu.jetpacklearn.base;

/**
 * author : xujianbo
 * date : 2021/3/22 10:05 下午
 * description :
 */
public interface ICustomView<S extends BaseViewModel> {
    void setData(S data);
}
