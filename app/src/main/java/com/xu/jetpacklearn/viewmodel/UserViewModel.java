package com.xu.jetpacklearn.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.xu.jetpacklearn.MyApplication;
import com.xu.jetpacklearn.model.User;
import com.xu.jetpacklearn.repository.UserRepository;

/**
 * author : xujianbo
 * date : 2/19/21 4:23 PM
 * description :
 */
public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepository;
    private LiveData<User> user;

    private String userName = "MichaelYe";

    public UserViewModel(@NonNull Application application) {
        super(application);


        this.userRepository = new UserRepository(MyApplication.getDataBase().userDao(), MyApplication.getApi());

        user = userRepository.getUser(userName);

    }


    public LiveData<User> getUser() {
        return user;
    }

    public void refresh() {
        userRepository.getFromNet(userName);
    }

}
