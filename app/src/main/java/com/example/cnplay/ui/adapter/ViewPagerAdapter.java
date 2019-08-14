package com.example.cnplay.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.cnplay.ui.bean.FragmentInfo;
import com.example.cnplay.ui.fragment.CategoryFragment;
import com.example.cnplay.ui.fragment.GamesFragment;
import com.example.cnplay.ui.fragment.RankingFragment;
import com.example.cnplay.ui.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author:LHT
 *     date:20190812
 *     desc:ViewPagerAdapter
 * </pre>
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<FragmentInfo> mFragments = new ArrayList<>(4);

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }

    private void initFragments() {

        mFragments.add(new FragmentInfo("推荐", RecommendFragment.class));
        mFragments.add(new FragmentInfo("排行", RankingFragment.class));
        mFragments.add(new FragmentInfo("游戏", GamesFragment.class));
        mFragments.add(new FragmentInfo("分类", CategoryFragment.class));

    }

    @Override
    public Fragment getItem(int i) {
        try {
            return (Fragment) mFragments.get(i).getFragment().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }
}
