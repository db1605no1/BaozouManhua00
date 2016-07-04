package com.example.baozoumanhua.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 荒原中的歌声 on 2016/7/4.
 */
public class ShouyeAdapter extends FragmentPagerAdapter{

    private   List<Fragment>   list;

    public ShouyeAdapter(FragmentManager fm, List<Fragment>  list){
        super(fm);

        this.list=list;
    }

    @Override
    public int getCount(){
        return list.size();
    }


    @Override
    public Fragment getItem(int position){

        return list.get(position);
    }


}
