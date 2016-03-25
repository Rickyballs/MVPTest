package com.ricky.mvptest.presenter;

import com.ricky.mvptest.model.MainModelBean;

/**
 * Created by Administrator on 2016/3/12.
 * 此接口作用是连接Model
 */
public interface IMainPresenter {
    void loadDataSuccess(MainModelBean mainModelBean);

    void loadDataFailure();
}
