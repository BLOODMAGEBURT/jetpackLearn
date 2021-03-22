package com.xu.jetpacklearn;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.bugly.crashreport.CrashReport;
import com.xu.jetpacklearn.api.Api;
import com.xu.jetpacklearn.api.RetrofitClient;
import com.xu.jetpacklearn.db.MyDataBase;

import org.jetbrains.annotations.NotNull;

import timber.log.Timber;

/**
 * author : xujianbo
 * date : 2/19/21 3:32 PM
 * description :
 */
public class MyApplication extends Application {

    private static Api api;
    private static MyDataBase myDataBase;
    private static final boolean FORCE_LOG = false;

    @Override
    public void onCreate() {
        super.onCreate();


        myDataBase = MyDataBase.getInstance(this);

        api = RetrofitClient.getInstance().getApi();


        initTimber();

        initBugly();

        // 通过注册监听生命周期
        logOnActivityCreate();

    }

    private void initBugly() {
        /**
         * 第三个参数为SDK调试模式开关，调试模式的行为特性如下：
         *
         * 输出详细的Bugly SDK的Log；
         * 每一条Crash都会被立即上报；
         * 自定义日志将会在Logcat中输出。
         * 建议在测试阶段建议设置成true，发布时设置为false。
         */
        CrashReport.initCrashReport(getApplicationContext());
    }

    private void initTimber() {

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }

        if (FORCE_LOG) {
            Timber.plant(new Timber.DebugTree());
        }

    }


    public static Api getApi() {
        return api;
    }

    public static MyDataBase getDataBase() {

        return myDataBase;
    }

    private void logOnActivityCreate() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                Timber.d("当前类是：%s", activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

            }
        });
    }

    private static class CrashReportingTree extends Timber.Tree {
        @Override
        protected void log(int priority, @org.jetbrains.annotations.Nullable String tag, @NotNull String message, @org.jetbrains.annotations.Nullable Throwable t) {

            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return;
            }
//            FakeCrashLibrary.log(priority, tag, message);
            if (t != null) {
                // bugly会将这个throwable上报
                CrashReport.postCatchedException(t);
                /*
                if (priority == Log.ERROR) {
                    // bugly会将这个throwable上报
                    CrashReport.postCatchedException(t);

                } else if (priority == Log.WARN) {
                    // bugly会将这个throwable上报
                    CrashReport.postCatchedException(t);
                }*/
            }
        }
    }
}
