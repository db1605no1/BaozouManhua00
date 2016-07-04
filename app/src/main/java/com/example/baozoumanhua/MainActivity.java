package com.example.baozoumanhua;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.baozoumanhua.adapter.MainVPAdapter;
import com.example.baozoumanhua.fragment.ChatFragment;
import com.example.baozoumanhua.fragment.CheckFragments;
import com.example.baozoumanhua.fragment.MakeFragment;
import com.example.baozoumanhua.fragment.SearchFragment;
import com.example.baozoumanhua.fragment.ShouyeFragment;
import com.example.baozoumanhua.viewpager.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends   MyActivity{

    @Bind(R.id.main_viewPager)
    MyViewPager myViewPager;
    @Bind(R.id.main_rb1)
    RadioButton mainRb1;
    @Bind(R.id.main_rb2)
    RadioButton mainRb2;
    @Bind(R.id.main_rb3)
    RadioButton mainRb3;
    @Bind(R.id.main_rb4)
    RadioButton mainRb4;
    @Bind(R.id.main_rb5)
    RadioButton mainRb5;
    @Bind(R.id.mainRadioGroup)
    RadioGroup mainRadioGroup;

    private List<Fragment> list = new ArrayList<>();
    private FragmentManager fragmentManager;
    private MainVPAdapter mainVPAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData(){
        //初始化主界面ViewPager
        fragmentManager = getSupportFragmentManager();
        CheckFragments checkFragments = new CheckFragments();
        ChatFragment chatFragment = new ChatFragment();
        SearchFragment searchFragment = new SearchFragment();
        MakeFragment makeFragment = new MakeFragment();
        ShouyeFragment shouyeFragment = new ShouyeFragment();
        list.add(shouyeFragment);
        list.add(searchFragment);
        list.add(makeFragment);
        list.add(checkFragments);
        list.add(chatFragment);
        Log.e("MainActivity", "fragmentManager:" + fragmentManager);
        Log.e("MainActivity", "list.size():" + list.size());
        mainVPAdapter = new MainVPAdapter(fragmentManager, list);
        myViewPager.setAdapter(mainVPAdapter);
        myViewPager.setCurrentItem(0);
        myViewPager.setPagingEnabled(false);
        //设置按钮和ViewPager的联动
        mainRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                myViewPager.setCurrentItem(mainRadioGroup.indexOfChild(findViewById(checkedId)));
            }
        });




    }
}
