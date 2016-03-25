package com.ricky.mvptest.view;

import com.ricky.mvptest.model.MainModelBean;

/**
 * Created by Administrator on 2016/3/12.
 * 定义处理业务需要哪些方法
 */
public interface MainView {
    void showData(MainModelBean mainModelBean);

    void showProgress();

    void hideProgress();
}
