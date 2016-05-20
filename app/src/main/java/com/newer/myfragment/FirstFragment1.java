package com.newer.myfragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * 底部导航栏第一个imageButton
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment1 extends Fragment{


    public FirstFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first_fragment1, container, false);
    }

}
