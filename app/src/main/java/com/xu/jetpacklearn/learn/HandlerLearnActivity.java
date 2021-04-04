package com.xu.jetpacklearn.learn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.xu.jetpacklearn.R;

import org.jetbrains.annotations.NotNull;

import java.lang.ref.WeakReference;

public class HandlerLearnActivity extends AppCompatActivity {

    TextView tv_hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_learn);

        tv_hello = findViewById(R.id.tv_hello);


        MyHandler myHandler = new MyHandler(Looper.getMainLooper(), new WeakReference<>(this));

        final Message obtain = Message.obtain();
        Message msg = obtain;
        msg.what = 1;
        msg.obj = "are you ok";
//        myHandler.sendMessage(msg);


        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv_hello.setText("update ui");
            }
        }, 5000);


        new Thread() {
            @Override
            public void run() {
                Message message = Message.obtain();
                message.what = 2;
                message.obj = "new world 2";
                myHandler.sendMessage(message);
            }
        }.start();


    }


    static class MyHandler extends Handler {

        private final WeakReference<HandlerLearnActivity> activity;

        public MyHandler(@NonNull @NotNull Looper looper, WeakReference<HandlerLearnActivity> activity) {
            super(looper);
            this.activity = activity;
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 1:
                case 2:
                    String text = (String) msg.obj;
                    activity.get().tv_hello.setText(text);
                    break;
                default:
                    break;
            }


        }
    }


}