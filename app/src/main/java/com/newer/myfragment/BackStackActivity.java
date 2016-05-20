package com.newer.myfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BackStackActivity extends Activity implements OneFragment.FOnewBtnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_stack);
        if(savedInstanceState == null){
            //第一次才会实例化
            FragmentManager manager = this.getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.id_content,new OneFragment(),"One");
            transaction.commit();
        }
    }

    @Override
    public void onFOnewBtnClick() {


    }
}
