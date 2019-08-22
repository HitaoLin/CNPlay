package com.example.cnplay.presenter.contract;

import com.example.cnplay.bean.AppInfo;
import com.example.cnplay.ui.BaseView;
import com.example.cnplay.presenter.BasePresenter;

import java.util.List;

public interface RecommendContract {

    interface View extends BaseView{

        void showResult(List<AppInfo> datas);
        void showNodata();
        void showErrow(String msg);

    }



}
