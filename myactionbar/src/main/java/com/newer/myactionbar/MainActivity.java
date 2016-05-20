package com.newer.myactionbar;

import android.content.Intent;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;

import java.security.Provider;

public class MainActivity extends AppCompatActivity {
    ActionBar bar;
    ShareActionProvider provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Android4.0以后ActionBar会先于界面绘制
        bar = this.getSupportActionBar();
        bar.setLogo(R.mipmap.ic_launcher);

        bar.setHomeButtonEnabled(true);//设置Home区域处于显示的状态
        bar.setDisplayUseLogoEnabled(true);//设置Logo图标显示
        bar.setDisplayShowCustomEnabled(true);//定制菜单项
        bar.setDisplayHomeAsUpEnabled(true);//返回按钮
        setContentView(R.layout.activity_main);
    }

    public Intent getDefaultIntent(){
        Intent myType  ;
        myType = new Intent(Intent.ACTION_SEND);
        myType.setType("image/*");
        return myType;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.new_actionbar_menu, menu);
        //--------------------------------分享----------------------
        MenuItem item = menu.findItem(R.id.menu_new_call);
        //获得Sharedprovider实例
        provider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
        provider.setShareIntent(this.getDefaultIntent());


        MenuItem item1 = menu.findItem(R.id.menu_new_call1);
//        MyActionProvider provider = new MyActionProvider(this);
//        item.setActionProvider(provider);
        //子菜单-----------------------------------
        ActionProvider provider = MenuItemCompat.getActionProvider(item1);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_new_call:
                Toast.makeText(this,"call",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
