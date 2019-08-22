package com.example.cnplay.di.component;

import com.example.cnplay.data.http.ApiService;
import com.example.cnplay.di.module.AppModule;
import com.example.cnplay.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    public ApiService getApiService();


}
