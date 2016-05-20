package com.newer.mynewbar;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

public class TabViewPageActivity extends AppCompatActivity {
    TableLayout tableLayout;//设置viewPage选项卡
    ViewPager viewPager;//实现View切换/滑动效果

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_view_page);
    }
}
