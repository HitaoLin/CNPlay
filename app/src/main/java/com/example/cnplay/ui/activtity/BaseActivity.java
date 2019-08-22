package com.example.cnplay.ui.activtity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.cnplay.AppApplication;
import com.example.cnplay.di.component.AppComponent;
import com.example.cnplay.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    private Unbinder mUnbinder;

    private AppApplication mAppApplication;

    @Inject
    T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(setLayout());
        mUnbinder = ButterKnife.bind(this);
        this.mAppApplication = (AppApplication) getApplication();
        setupActivityComponent(mAppApplication.getAppComponent());

        init();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mUnbinder != Unbinder.EMPTY){
            mUnbinder.unbind();
        }

    }

    public abstract int setLayout();

    public abstract void setupActivityComponent(AppComponent appComponent);

    public abstract void init();
}
