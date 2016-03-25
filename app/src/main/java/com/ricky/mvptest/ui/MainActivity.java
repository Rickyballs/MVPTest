package com.ricky.mvptest.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ricky.mvptest.R;
import com.ricky.mvptest.model.MainModelBean;
import com.ricky.mvptest.presenter.MainPresenter;
import com.ricky.mvptest.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView{
    private ProgressBar mProgressBar;
    private TextView text;
    private MainPresenter mMainPresenter;//持有Presenter这个中间人
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        text= (TextView) findViewById(R.id.text);
        mProgressBar= (ProgressBar) findViewById(R.id.mProgressBar);
        mMainPresenter=new MainPresenter(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mMainPresenter.loadData();
            }
        },2000);
    }

    @Override
    public void showData(MainModelBean mainModelBean) {
        String showData=getResources().getString(R.string.city)+mainModelBean.getCity()+
                getResources().getString(R.string.wd)+mainModelBean.getWd()+
                getResources().getString(R.string.ws)+mainModelBean.getWs()+
                getResources().getString(R.string.time)+mainModelBean.getTime();
        text.setText(showData);


    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);

    }

    @Override
    protected void onDestroy() {
        mMainPresenter.detachView();
        super.onDestroy();
    }
}
