package com.newer.myfragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends Fragment implements View.OnClickListener{
    Button click;

    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View three_view = null;
        three_view = inflater.inflate(R.layout.fragment_three, container, false);
        click = (Button) three_view.findViewById(R.id.id_fragment_three_btn);
        click.setOnClickListener(this);
        return three_view;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(ThreeFragment.this.getActivity(),"ssssssss",Toast.LENGTH_LONG).show();
    }
}
