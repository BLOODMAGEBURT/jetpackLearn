package com.xu.jetpacklearn.api;

import com.xu.jetpacklearn.base.BaseResponse;
import com.xu.jetpacklearn.model.ApproveNode;
import com.xu.jetpacklearn.model.BasicInfo;
import com.xu.jetpacklearn.model.BudgetBean;
import com.xu.jetpacklearn.model.ExpenseBean;
import com.xu.jetpacklearn.model.FactorBean;
import com.xu.jetpacklearn.model.FactorRequest;
import com.xu.jetpacklearn.model.User;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

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

    // 直接报销-获取支出和预算列表
    @GET("bill/budgetTarget/list/v2")
    Observable<BaseResponse<List<BudgetBean>>> getBudgets(@Query("mainId") String mainId);

    // 审批-获取审批流程
    @GET("actex/actexTask/getCheckTaskList")
    Observable<BaseResponse<List<ApproveNode>>> getApproveNodes(@QueryMap HashMap<String, Integer> queryMap);

    // 审批-获取审批要素
    @POST("bill/approveFactorInfo/queryList")
    Observable<BaseResponse<List<FactorBean>>> getFactorBeans(@Body FactorRequest request);

}
