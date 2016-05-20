package com.newer.myfragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment implements View.OnClickListener{
    Button btn_two;
    //
    public interface FOnewBtnClickListener{
        //响应点击跳转到第二个Fragment
        void onFOnewBtnClick();
    }

//    public OneFragment() {
//        // Required empty public constructor
//    }
//
//
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View oneView = null;
        oneView = inflater.inflate(R.layout.fragment_one, container, false);
        btn_two = (Button) oneView.findViewById(R.id.id_fragment_one_btn);
        btn_two.setOnClickListener(this);
        return oneView;

    }

    @Override
    public void onClick(View v) {
//        FragmentManager manager = this.getFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        TwoFragment twoFragment = new TwoFragment();
//        //
//        transaction.replace(R.id.id_content,twoFragment,"Two");
//        //将TwoFragment加入到回退栈
//        //用户按下返回键，可以从回退栈中弹出TwoFragment
//        transaction.addToBackStack(null);
//        transaction.commit();
        if(getActivity() instanceof FOnewBtnClickListener){
            ((FOnewBtnClickListener)getActivity()).onFOnewBtnClick();
        }

    }
}
