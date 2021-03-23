package com.xu.jetpacklearn.api;

import com.xu.jetpacklearn.base.BaseResponse;
import com.xu.jetpacklearn.model.BasicInfo;
import com.xu.jetpacklearn.model.ExpenseBean;
import com.xu.jetpacklearn.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * author : xujianbo
 * date : 2/19/21 3:33 PM
 * description :
 */
public interface Api {
    @GET("users/{userId}")
    Call<User> getUser(@Path("userId") String userId);


    // 直接报销-获取基本信息
    @GET("bill/billMain/queryById")
    Observable<BaseResponse<BasicInfo>> getBasicInfo(@Query("id") String id);

    // 直接报销-获取支出事项
    @GET("bill/expensesExpendDetail/list")
    Observable<BaseResponse<List<ExpenseBean>>> getExpense(@Query("mainId") String mainId);

    // bill/budgetTarget/list/v2

}
