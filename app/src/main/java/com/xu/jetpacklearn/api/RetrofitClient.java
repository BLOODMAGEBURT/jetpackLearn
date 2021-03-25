package com.xu.jetpacklearn.api;

import com.github.simonpercic.oklog.core.LogInterceptor;
import com.github.simonpercic.oklog3.OkLogInterceptor;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
                .addInterceptor(new TokenInterceptor())
                .build();

        return httpClient;
    }

    /**
     * token全局拦截器
     */
    public static class TokenInterceptor implements Interceptor {

        @NotNull
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request().newBuilder()
                    .addHeader("X-Access-Token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTcyNjMyNzIsInVzZXJuYW1lIjoi6K645YmR5rOiIn0.u5aAocZ5fqqZTCYKcBDWkLzLvfNYfH6TOnxfL2-NzvQ")
                    .build();

            return chain.proceed(request);
        }

    }


    public Api getApi() {
        return retrofit.create(Api.class);
    }


}
