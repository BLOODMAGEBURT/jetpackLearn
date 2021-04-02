package com.xu.jetpacklearn.learn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author : xujianbo
 * date : 2021/4/1 9:10 下午
 * description : 学习线程池
 */
public class ThreadLearn {


    public void test() {

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("are you ok?");
            }
        });
    }


}
