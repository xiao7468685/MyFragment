package com.newer.mynewbar;


import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;
    SpinnerAdapter spinnerAdapter;
    String[] myOptions = new String[]{"剪切","复制","粘贴"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //使用ActionBar实现下拉导航
        actionBar = this.getSupportActionBar();
        actionBar.setTitle("下拉");
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        spinnerAdapter = ArrayAdapter.createFromResource(this,R.array.myspinner,android.R.layout.simple_spinner_dropdown_item);

        ActionBar.OnNavigationListener navigationListener = new ActionBar.OnNavigationListener() {
            @Override
            public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                //Spinner下拉列表中选中的选项
                Fragment fragment = null;
                switch (itemPosition){
                    case 0:
                        fragment = new OneFragment();
                        //选中Spinner选项后，切换
                        break;
                    case 1:
                        fragment = new TwoFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.spinner_content,fragment,myOptions[itemPosition]).commit();
                return true;
            }
        };
        actionBar.setListNavigationCallbacks(spinnerAdapter,navigationListener);
    }
}
