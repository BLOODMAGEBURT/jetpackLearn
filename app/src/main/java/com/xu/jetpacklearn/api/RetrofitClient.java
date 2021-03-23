package com.xu.jetpacklearn.api;

import com.github.simonpercic.oklog.core.LogInterceptor;
import com.github.simonpercic.oklog3.OkLogInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author : xujianbo
 * date : 2/19/21 3:36 PM
 * description :
 */
public class RetrofitClient {

    private static final String BASE_URL = "http://znk-dev.rotosix.cn/";

    private static RetrofitClient retrofitClient;
    private final Retrofit retrofit;

    private RetrofitClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    public static RetrofitClient getInstance() {

        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }

        return retrofitClient;
    }

    public OkHttpClient getHttpClient() {

        // create an instance of OkLogInterceptor using a builder()
        OkLogInterceptor okLogInterceptor = OkLogInterceptor.builder()
                .setLogInterceptor(url -> false) //If you return true from this method, the string will not be logged.
                .build();

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(okLogInterceptor)
                .build();

        return httpClient;
    }


    public Api getApi() {
        return retrofit.create(Api.class);
    }



}
