package com.xu.jetpacklearn.db;

import android.content.Context;

import androidx.core.content.ContextCompat;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.xu.jetpacklearn.model.User;

/**
 * author : xujianbo
 * date : 2/19/21 3:18 PM
 * description :
 */
@Database(entities = {User.class}, version = 1)
public abstract class MyDataBase extends RoomDatabase {

    private static final String DATABASE_NAME = "my_db";

    private static MyDataBase instance;

    public static synchronized MyDataBase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MyDataBase.class, DATABASE_NAME)
                    .build();
        }

        return instance;
    }

    public abstract UserDao userDao();

}
