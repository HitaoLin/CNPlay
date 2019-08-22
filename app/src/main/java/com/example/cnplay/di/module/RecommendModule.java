package com.example.cnplay.di.module;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.cnplay.data.RecommendModel;
import com.example.cnplay.data.http.ApiService;
import com.example.cnplay.presenter.RecommendPresenter;
import com.example.cnplay.presenter.contract.RecommendContract;
import com.example.cnplay.ui.fragment.RecommendFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class RecommendModule {

    private RecommendContract.View mView;

    public RecommendModule(RecommendContract.View view) {
        mView = view;
    }


    @Provides
    public RecommendContract.Presenter providesPresenter(RecommendContract.View view,RecommendModel model){
        return new RecommendPresenter(view,model);
    }

    @Provides
    public RecommendContract.View provideView(){
        return mView;
    }

    @Provides
    public RecommendModel provideRecommendModel(ApiService apiService){
        return new RecommendModel(apiService);
    }

    @Provides
    public ProgressDialog provideProgressDialog(RecommendContract.View view){
        return new ProgressDialog(((RecommendFragment) view).getActivity());
    }


}
