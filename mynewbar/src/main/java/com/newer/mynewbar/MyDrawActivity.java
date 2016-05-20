package com.newer.mynewbar;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyDrawActivity extends AppCompatActivity {
    ListView listView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_draw);
        listView = (ListView) findViewById(R.id.id_lv);
        drawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);
        //抽屉上的选项：
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,new String[]{"剪切","复制","粘贴"});
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MyDrawActivity.this,String.valueOf(position),Toast.LENGTH_LONG).show();
            }
        });
        //listView.setOnItemClickListener();
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            //slide：滑动
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
//                Toast.makeText(MyDrawActivity.this,"抽屉滑动",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
//                Toast.makeText(MyDrawActivity.this,"抽屉打开",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
//                Toast.makeText(MyDrawActivity.this,"抽屉关闭",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDrawerStateChanged(int newState) {
//                Toast.makeText(MyDrawActivity.this,"抽屉状态："+newState,Toast.LENGTH_LONG).show();
            }
        });
    }
}
