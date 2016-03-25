package com.ricky.mvptest.model;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.ricky.mvptest.presenter.IMainPresenter;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/3/12.
 */
public class MainModel {
    IMainPresenter mIMainPresenter;//持有中间人的接口

    public MainModel(IMainPresenter iMainPresenter){
        this.mIMainPresenter=iMainPresenter;
    }

    public void loadData(){
        AsyncHttpClient asyncHttpClient=new AsyncHttpClient();
        asyncHttpClient.get("http://www.weather.com.cn/adat/sk/101010100.html",new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.w("onSuccess",response.toString());
                try {
                    MainModelBean mainModelBean=new MainModelBean();
                    JSONObject weatherinfo= response.getJSONObject("weatherinfo");
                    mainModelBean.setCity(weatherinfo.getString("city"));
                    mainModelBean.setWd(weatherinfo.getString("WD"));
                    mainModelBean.setWs(weatherinfo.getString("WS"));
                    mainModelBean.setTime(weatherinfo.getString("time"));
                    Log.w("json",mainModelBean.toString());
                    mIMainPresenter.loadDataSuccess(mainModelBean);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                mIMainPresenter.loadDataFailure();
            }
        });
    }
}
