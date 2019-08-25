package com.example.cnplay.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideFragmentAdapter extends FragmentStatePagerAdapter {

    List<Fragment> mFragments;

    public void setFragments(List<Fragment> fragments) {

        if (fragments == null){
            mFragments = new ArrayList<>();
        }else
            mFragments = fragments;
    }

    public GuideFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
