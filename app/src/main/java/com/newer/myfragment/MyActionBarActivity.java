package com.newer.myfragment;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MyActionBarActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.setTitle("移动计步器");
        setContentView(R.layout.activity_my_action_bar);
        ActionBar actionBar = this.getSupportActionBar();
        //打开ActionBar左侧标题图片的返回按钮
        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.show();//显示
//        actionBar.hide();//隐藏
//        actionBar.setLogo(R.drawable.pedometer);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.actionbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_call:
                Toast.makeText(this,"call",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_copy:
                Toast.makeText(this,"copy",Toast.LENGTH_LONG).show();
                break;
            case R.id.home:
                //左侧返回按钮
                Toast.makeText(MyActionBarActivity.this,"返回",Toast.LENGTH_LONG).show();
                Intent upintent = NavUtils.getParentActivityIntent(this);
                //犹豫actionbar启用了service
                if(NavUtils.shouldUpRecreateTask(this,upintent)){
                    //true重新创建
                    TaskStackBuilder.create(this).addNextIntentWithParentStack(upintent).startActivities();
                }else {
                    //false:Task还在，清空栈顶Activity
                    upintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    NavUtils.navigateUpTo(this,upintent);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }
}
