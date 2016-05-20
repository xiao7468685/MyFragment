package com.newer.myactionbar;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;

/**
 * Created by Administrator on 2016/4/21.
 */
public class MyTabListener<T extends Fragment> implements ActionBar.TabListener {
    Fragment fragment;
    private final Activity mActivity;
    private final String mTag;
    private final Class<T> mClass;

    public MyTabListener(Activity activity,String tagName,Class<T> MyFragment) {
        mActivity = activity;
        mTag = tagName;
        mClass = MyFragment;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        //选中ActionBar中选项卡
        //实例化Fragment
        /**
         * 1、已经实例化过Fragment
         * FragmentTransaction
         */
        if(fragment == null){
            fragment = Fragment.instantiate(mActivity,mClass.getName());
            ft.add(android.R.id.content,fragment,mTag);
        }else {
            ft.attach(fragment);
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        //切换到下第一个选项卡，离开当前选项卡
        //销毁Fragmen
        if(fragment != null){
            ft.detach(fragment);
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
