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
public class TwoFragment extends Fragment implements View.OnClickListener{
    Button btn_three;


    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View two_view = null;
        two_view = inflater.inflate(R.layout.fragment_two, container, false);
        btn_three = (Button) two_view.findViewById(R.id.id_fragment_two_btn);
        btn_three.setOnClickListener(this);
        return two_view;
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = this.getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        ThreeFragment threeFragment = new ThreeFragment();
        transaction.hide(this);
        transaction.add(R.id.id_content,threeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
