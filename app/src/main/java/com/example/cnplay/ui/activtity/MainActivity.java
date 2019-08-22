package com.example.cnplay.ui.activtity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.cnplay.R;
import com.example.cnplay.di.component.AppComponent;
import com.example.cnplay.ui.adapter.ViewPagerAdapter;
import com.mikepenz.iconics.context.IconicsLayoutInflater;


public class MainActivity extends BaseActivity {

    private Toolbar mToolBar;
    private ViewPager mViewPager;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private TabLayout mTabLayout;
    View headerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        LayoutInflaterCompat.setFactory(getLayoutInflater(),new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);





    }

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void init() {
        initView();
        initDrawerLayout();
        initTabLayout();
    }

    private void initTabLayout() {

        PagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void initView() {

        mToolBar = findViewById(R.id.tool_bar);
        mViewPager = findViewById(R.id.view_pager);
        mNavigationView = findViewById(R.id.navigation_view);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mTabLayout = findViewById(R.id.tab_layout);

    }

    private void initDrawerLayout() {


        headerView = mNavigationView.getHeaderView(0);

        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "headerView clicked", Toast.LENGTH_LONG).show();
            }
        });


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.menu_app_update:
                        Toast.makeText(MainActivity.this, "点击了应用更新", Toast.LENGTH_LONG).show();
                        break;

                    case R.id.menu_message:
                        Toast.makeText(MainActivity.this, "点击了消息", Toast.LENGTH_LONG).show();
                        break;

                    case R.id.menu_setting:
                        Toast.makeText(MainActivity.this, "点击了设置", Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }
        });


        mToolBar.inflateMenu(R.menu.toolbar_menu);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.open, R.string.close);
        drawerToggle.syncState();
        mDrawerLayout.addDrawerListener(drawerToggle);

    }

}
