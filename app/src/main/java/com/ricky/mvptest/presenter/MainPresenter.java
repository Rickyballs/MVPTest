package com.ricky.mvptest.presenter;

import com.ricky.mvptest.model.MainModel;
import com.ricky.mvptest.model.MainModelBean;
import com.ricky.mvptest.view.MainView;

/**
 * Created by Administrator on 2016/3/12.
 */
public class MainPresenter implements Presenter<MainView>,IMainPresenter{
    private MainView mMainView;
    private MainModel mMainModel;

    public MainPresenter(MainView view){
        attachView(view);
        mMainModel=new MainModel(this);
    }
    public void loadData() {
        mMainView.showProgress();
        mMainModel.loadData();
    }

    @Override
    public void attachView(MainView view) {
        this.mMainView=view;

    }

    public void detachView() {
        this.mMainView=null;
    }

    @Override
    public void loadDataSuccess(MainModelBean mainModelBean) {
        mMainView.showData(mainModelBean);
        mMainView.hideProgress();

    }

    @Override
    public void loadDataFailure() {
        mMainView.hideProgress();

    }
}
