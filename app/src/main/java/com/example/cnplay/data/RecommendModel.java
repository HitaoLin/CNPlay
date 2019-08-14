package com.example.cnplay.data;

import com.example.cnplay.bean.AppInfo;
import com.example.cnplay.bean.PageBean;
import com.example.cnplay.http.ApiService;
import com.example.cnplay.http.HttpManager;

import retrofit2.Callback;

public class RecommendModel {

    public void getApps(Callback<PageBean<AppInfo>> callback){

        HttpManager manager = new HttpManager();
        ApiService apiService = manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);
        apiService.getApps("{'page':0}").enqueue(callback);

    }

}
