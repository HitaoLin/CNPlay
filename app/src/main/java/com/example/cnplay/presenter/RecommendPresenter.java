package com.example.cnplay.presenter;

import com.example.cnplay.bean.AppInfo;
import com.example.cnplay.bean.PageBean;
import com.example.cnplay.data.RecommendModel;
import com.example.cnplay.presenter.contract.RecommendContract;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendPresenter extends BasePresenter<RecommendModel,RecommendContract.View> {

    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view) {
        super(model, view);
    }


    public void requestDatas() {

        mView.showLoading();

        mModel.getApps(new Callback<PageBean<AppInfo>>(){

            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {

                if (response != null){
                    mView.showResult(response.body().getDatas());
                }else {
                    mView.showNodata();
                }

                mView.dismissLoading();

            }

            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
                mView.dismissLoading();
                mView.showErrow(t.getMessage());
            }
        });




    }
}
