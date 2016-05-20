package com.newer.myfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**界面标题栏
 * Created by Administrator on 2016/4/18.
 */
public class TitleBarFragment extends Fragment{
    ImageButton imageButton;
    //Fragment显示返回的view
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = null;
        fragmentView = inflater.inflate(R.layout.fragment_title_bar,container,false);
        imageButton = (ImageButton) fragmentView.findViewById(R.id.id_title_left_btn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //android:5.0以下用getActivity()
                Toast.makeText(TitleBarFragment.this.getActivity(),"点击按钮",Toast.LENGTH_LONG).show();
            }
        });
        return fragmentView;
    }
}
