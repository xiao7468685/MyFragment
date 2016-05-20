package com.newer.myactionbar;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

/**
 * ActionBar上生成子菜单SubMenu
 * Created by Administrator on 2016/4/21.
 */
public class MyActionProvider extends ActionProvider {
    Context ct = null;

    /**
     * Creates a new instance.
     *
     * @param context Context for accessing resources.
     */
    public MyActionProvider(Context context) {
        super(context);
        this.ct = context;
    }
        //ActionProvider显示在ActionBar上的文字和图片
    @Override
    public View onCreateActionView() {
        return null;
    }
//代表打开ActionProvider子菜单功能
   @Override
    public boolean hasSubMenu() {
        return true;
    }
//在ActionProvider中绘制子菜单项
    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        super.onPrepareSubMenu(subMenu);
        subMenu.clear();//清除上一次显示饿子菜单
        subMenu.add("子菜单1").setIcon(R.drawable.ic_action_paste).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(ct, "sssss2", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        subMenu.add("子菜单2").setIcon(R.drawable.ic_action_paste).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(ct,"sssss1",Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
}
