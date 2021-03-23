package com.xu.jetpacklearn.base;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

// Observer基类
public abstract class BaseObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }


    @Override
    public void onError(Throwable e) {
        onFailure(e);
    }

    @Override
    public void onComplete() {

    }


    public abstract void onSuccess(T t);

    public abstract void onFailure(Throwable e);
}
