package com.newer.myactionbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * 选项菜单
 */
public class TabNavigateActivity extends AppCompatActivity {
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bar = this.getSupportActionBar();
        setContentView(R.layout.activity_tab_navigate);
        //使用ActionBar实现选项卡
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //项ActionBar添加选项卡=
        ActionBar.Tab mytab1= bar.newTab().setText("选项卡1").setTabListener(new MyTabListener<FirstFragment>(TabNavigateActivity.this,"拨号",FirstFragment.class));
        ActionBar.Tab mytab2 = bar.newTab().setText("选项卡2").setTabListener(new MyTabListener<TwoFragment>(TabNavigateActivity.this,"拨号",TwoFragment.class));
        bar.addTab(mytab1);
        bar.addTab(mytab2);
    }

}
