package com.newer.mytoolbar;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar mytoolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    int myNumTabs;//代表选项卡的个数

    class  MyPageAdapter extends FragmentStatePagerAdapter{

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        public MyPageAdapter(FragmentManager fm,int numTabs) {
            super(fm);
            myNumTabs = numTabs;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    //VIewPage中滑动的第一个页面
                    BlankFragment one = new BlankFragment();
                    return one;
                case 1:
                    TwoFragment two = new TwoFragment();
                    return two;
                default:
                    break;
            }
            return null;
        }

        @Override
        public int getCount() {
            return myNumTabs;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytoolbar = (Toolbar) findViewById(R.id.toolBar);
        mytoolbar.setLogo(R.mipmap.ic_launcher);
        mytoolbar.setTitle("工具栏");
        mytoolbar.setSubtitle("子标题");
        mytoolbar.setNavigationIcon(R.drawable.ic_action_call);
        setSupportActionBar(mytoolbar);
        mytoolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_copy:
                        Toast.makeText(MainActivity.this, "复制", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_cut:
                        Toast.makeText(MainActivity.this, "剪切", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_paste:
                        Toast.makeText(MainActivity.this, "粘贴", Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }
        });
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        //新增选项卡
        tabLayout.addTab(tabLayout.newTab().setText("第一个选项卡"));
        tabLayout.addTab(tabLayout.newTab().setText("第二个选项卡"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //捆绑ViewPage适配器
        MyPageAdapter myPageAdapter = new MyPageAdapter(getSupportFragmentManager(),2);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(myPageAdapter);
        //每一个见面切换
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选项卡切换
                //选中选项卡Tab，显示ViewPage对应的Fragment
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //TabLayout捆绑Layout
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.my_toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
