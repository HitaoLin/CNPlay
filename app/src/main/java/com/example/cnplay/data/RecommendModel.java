package com.example.cnplay.data;

import com.example.cnplay.bean.AppInfo;
import com.example.cnplay.bean.PageBean;
import com.example.cnplay.data.http.ApiService;
import com.example.cnplay.data.http.HttpManager;

import retrofit2.Callback;

public class RecommendModel {


    private ApiService mApiService;

    public RecommendModel(ApiService apiService){
        this.mApiService = apiService;
    }

    public void getApps(Callback<PageBean<AppInfo>> callback){

//        HttpManager manager = new HttpManager();
//        ApiService apiService = manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);
        mApiService.getApps("{'page':0}").enqueue(callback);

    }

}
