package com.example.baozoumanhua.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.baozoumanhua.R;
import com.example.baozoumanhua.adapter.ShouyeAdapter;
import com.example.baozoumanhua.fragment.fragment2.GuanzhuFragment;
import com.example.baozoumanhua.fragment.fragment2.JingxuanFragment;
import com.example.baozoumanhua.fragment.fragment2.ZuixinFragment;
import com.example.baozoumanhua.viewpager.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouyeFragment extends Fragment{



    private List<Fragment> list = new ArrayList<>();
    private FragmentManager fragmentManager;
    private ShouyeAdapter  shouyeAdapter;
    @Bind(R.id.shouye_rb1)
    RadioButton shouyeRb1;
    @Bind(R.id.shouye_rb2)
    RadioButton shouyeRb2;
    @Bind(R.id.shouye_rb3)
    RadioButton shouyeRb3;
    @Bind(R.id.shouye_radioGroup)
    RadioGroup shouyeRadioGroup;
    @Bind(R.id.shouye_viewPager)
    MyViewPager shouyeViewPager;

    public ShouyeFragment(){
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ButterKnife.bind(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shouye, container, false);
        ButterKnife.bind(this, view);
        
        initData();
        return view;
        
        
        
        
        
        
        
        
    }

    private void initData(){
        fragmentManager = getActivity().getSupportFragmentManager();
        GuanzhuFragment  guanzhuFragment=new GuanzhuFragment();
        JingxuanFragment  jingxuanFragment=new JingxuanFragment();
        ZuixinFragment  zuixinGragment=new ZuixinFragment();
        list.add(zuixinGragment);
        list.add(jingxuanFragment);

        list.add(guanzhuFragment);
        ShouyeAdapter  sa=new ShouyeAdapter(fragmentManager,list);


        shouyeViewPager.setAdapter(sa);

        shouyeViewPager.setCurrentItem(0);

shouyeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId){

        shouyeViewPager.setCurrentItem(shouyeRadioGroup.indexOfChild(getActivity().findViewById(checkedId)));
    }
});


    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
