package com.newer.mynewbar;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageChangeFragment extends Fragment {
    TabLayout tabLayout = null;//设置ViewPage选项卡
    ViewPager viewPager = null;//实现View切换/滑动特效

    List<Fragment> allPageFragments = null;
    List<String> allPageTitles = null;
    MyPageAdapter myPageAdapter = null;

    public PageChangeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myPageChangeView = inflater.inflate(R.layout.fragment_page_change, container, false);
        initControls(myPageChangeView);
        return myPageChangeView;
    }

    public void initControls(View v) {
        tabLayout = (TabLayout) v.findViewById(R.id.tab_FindFragment_title);
        viewPager = (ViewPager) v.findViewById(R.id.vp_FindFragment_pager);

        allPageFragments = new ArrayList<Fragment>();
        allPageFragments.add(new OneFragment());
        allPageFragments.add(new TwoFragment());

        allPageTitles = new ArrayList<String>();
        allPageTitles.add("剪切");
        allPageTitles.add("复制");

        myPageAdapter = new MyPageAdapter(getFragmentManager(), allPageFragments, allPageTitles);

        //设置ViewPage切换
        viewPager.setAdapter(myPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
