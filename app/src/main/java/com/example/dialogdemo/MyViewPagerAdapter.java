package com.example.dialogdemo;



import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;
    private List<String> titles;

    MyViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    void setFragments(List<Fragment> fragments,List<String> titles) {
        this.fragments = fragments;
        this.titles=titles;
    }


    //获取碎片位置
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    //获取碎片数量
    @Override
    public int getCount() {
        return fragments.size();
    }


    //获取标题位置
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public CharSequence getPageTitle(int position) {

        return titles.get(position);

    }
}
