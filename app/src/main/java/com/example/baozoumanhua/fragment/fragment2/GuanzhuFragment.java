package com.example.baozoumanhua.fragment.fragment2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baozoumanhua.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuanzhuFragment extends Fragment{

    public GuanzhuFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guanzhu, container, false);
    }
}
