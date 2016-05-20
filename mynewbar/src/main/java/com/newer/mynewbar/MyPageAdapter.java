package com.newer.mynewbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/4/25.
 */
public class MyPageAdapter extends FragmentPagerAdapter {
    //切换Fragment
    List<Fragment> allPageFragments = null;
    //每一页的选项卡标题文字
    List<String> allPageTitles = null;

    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyPageAdapter(FragmentManager fm, List<Fragment> myallPageFragments, List<String> myallPageTitles) {
        super(fm);
        this.allPageFragments = myallPageFragments;
        this.allPageTitles = myallPageTitles;
    }

    //当前切换Page显示的Fragment
    @Override
    public Fragment getItem(int position) {
        return allPageFragments.get(position);
    }

    //生成多少Page
    @Override
    public int getCount() {
        return allPageFragments.size();
    }

    //选项卡上方的文字：
    @Override
    public CharSequence getPageTitle(int position) {
        return allPageTitles.get(position % allPageFragments.size());
    }
}
