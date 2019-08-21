package com.example.cnplay.di;

import com.example.cnplay.presenter.RecommendPresenter;
import com.example.cnplay.presenter.contract.RecommendContract;
import com.example.cnplay.ui.adapter.RecomendAppAdatper;

import dagger.Module;
import dagger.Provides;

@Module
public class RecommendModule {

    private RecommendContract.View mView;

    public RecommendModule(RecommendContract.View view) {
        mView = view;
    }

    @Provides
    public RecommendContract.Presenter providesPresenter(RecommendContract.View view){
        return new RecommendPresenter(view);
    }

    @Provides
    public RecommendContract.View provideView(){
        return mView;
    }

//    @Provides
//    public RecomendAppAdatper provideAdapter(){
//        return null;
//    }

}
