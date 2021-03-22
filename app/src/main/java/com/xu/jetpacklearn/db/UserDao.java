package com.xu.jetpacklearn.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.xu.jetpacklearn.model.User;

/**
 * author : xujianbo
 * date : 2/19/21 3:11 PM
 * description :
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("select * from user where name = :name")
    LiveData<User> getUserByName(String name);
}
