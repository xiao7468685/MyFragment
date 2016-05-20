package com.newer.myfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BottomBarActivity extends Activity implements View.OnClickListener {
    ImageButton button1;
    ImageButton button2;
    FirstFragment1 firstFragment1;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);
        button1 = (ImageButton) findViewById(R.id.btn_01);
        button2 = (ImageButton) findViewById(R.id.btn_02);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        this.setDefaulFragment();
    }
//初始化进入ACtivity，加载默认Fragment
    public void setDefaulFragment(){
        //第一步：取得服务
        FragmentManager manager = this.getFragmentManager();
        //第二步：取得Fragment事物
        FragmentTransaction transaction = manager.beginTransaction();
        //第三部：添加/删除/替换Fragment
        firstFragment1 = new FirstFragment1();
        transaction.replace(R.id.id_content,firstFragment1);
        //第四步：提交
        transaction.commit();
    }
    @Override
    public void onClick(View v) {
        FragmentManager manager = this.getFragmentManager();
        //第二步：取得Fragment事物
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()){
            case R.id.btn_01:
                if(firstFragment1 == null){
                    firstFragment1 = new FirstFragment1();
                }
                transaction.replace(R.id.id_content,firstFragment1);
                break;
            case R.id.btn_02:
                if(secondFragment == null){
                    secondFragment= new SecondFragment();
                }
                transaction.replace(R.id.id_content,secondFragment);
                break;
        }
        transaction.commit();
    }

}
