package com.example.cnplay.ui.activtity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.cnplay.R;
import com.example.cnplay.common.Constant;
import com.example.cnplay.common.util.ACache;
import com.example.cnplay.ui.adapter.GuideFragmentAdapter;
import com.example.cnplay.ui.fragment.GuideFragment;
import com.example.cnplay.ui.widget.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <pre>
 *     desc:启动页面
 * </pre>
 */
public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.indicator)
    CircleIndicator indicator;
    @BindView(R.id.btn_enter)
    Button btnEnter;

    private GuideFragmentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

        initData();

    }

    private void initData() {

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(GuideFragment.newInstance(R.drawable.guide_1,R.color.hotpink,R.string.guide_1));
        fragments.add(GuideFragment.newInstance(R.drawable.guide_2,R.color.lightskyblue,R.string.guide_2));
        fragments.add(GuideFragment.newInstance(R.drawable.guide_3,R.color.mediumaquamarine,R.string.guide_3));

        mAdapter = new GuideFragmentAdapter(getSupportFragmentManager());
        mAdapter.setFragments(fragments);

        viewpager.setCurrentItem(0);
        viewpager.setOffscreenPageLimit(mAdapter.getCount());
        viewpager.setAdapter(mAdapter);

        viewpager.addOnPageChangeListener(this);

        indicator.setViewPager(viewpager);

    }

    @OnClick(R.id.btn_enter)
    public void onViewClicked() {

        ACache.get(this).put(Constant.IS_SHOW_GUIDE,"0");
        startActivity(new Intent(this,MainActivity.class));
        this.finish();

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
        btnEnter.setVisibility((i == mAdapter.getCount() - 1) ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
