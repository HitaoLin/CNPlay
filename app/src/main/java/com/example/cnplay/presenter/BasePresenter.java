package com.example.cnplay.presenter;

import com.example.cnplay.ui.BaseView;

public class BasePresenter<M,V extends BaseView>{

    protected M mModel;

    protected V mView;

    public BasePresenter(M m, V v) {
        this.mModel = m;
        this.mView = v;
    }
}
