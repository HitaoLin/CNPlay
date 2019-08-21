package com.example.cnplay.di;

import com.example.cnplay.ui.fragment.RecommendFragment;

import dagger.Component;

@Component(modules = RecommendModule.class)
public interface RecommendComponent {

    void inject(RecommendFragment fragment);

}
