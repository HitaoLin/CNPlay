package com.example.cnplay.di.component;

import com.example.cnplay.di.FragmentScope;
import com.example.cnplay.di.module.RecommendModule;
import com.example.cnplay.ui.fragment.RecommendFragment;

import dagger.Component;

@FragmentScope
@Component(modules = RecommendModule.class,dependencies = AppComponent.class)
public interface RecommendComponent {

    void inject(RecommendFragment fragment);

}
