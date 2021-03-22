package com.xu.jetpacklearn.repository;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.xu.jetpacklearn.api.Api;
import com.xu.jetpacklearn.db.UserDao;
import com.xu.jetpacklearn.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * author : xujianbo
 * date : 2/19/21 3:50 PM
 * description :
 */
public class UserRepository {
    private UserDao userDao;
    private Api api;

    public UserRepository(UserDao userDao, Api api) {
        this.userDao = userDao;
        this.api = api;
    }

    public LiveData<User> getUser(String userName) {

        getFromNet(userName);

        LiveData<User> user = userDao.getUserByName(userName);

        return user;
    }

    public void getFromNet(String userName) {

        api.getUser(userName).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body() != null) {
                    insertUser(response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }

    private void insertUser(final User body) {
        // 需要在子线程中运行
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUser(body);
            }
        });

    }

}
