package com.ricky.mvptest.presenter;

/**
 * Created by Administrator on 2016/3/12.
 */
public interface Presenter<V> {
    void attachView(V view);
    void detachView();
}
