package com.xu.jetpacklearn.api;

import com.xu.jetpacklearn.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * author : xujianbo
 * date : 2/19/21 3:33 PM
 * description :
 */
public interface Api {
    @GET("users/{userId}")
    Call<User> getUser(@Path("userId") String userId);

}
