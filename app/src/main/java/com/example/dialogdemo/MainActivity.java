package com.example.dialogdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
/*import android.app.Fragment;*/

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    /*private List<Fragment> list2;*/
    private TabLayout tabLayout;
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SimpleDateFormat formatter    =   new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss     ");
        Date    curDate    =   new Date(System.currentTimeMillis());
        String    str    =    formatter.format(curDate);
        Log.d("activitylife", "onCreate called   . 时间: "+str);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ViewPager vp = (ViewPager) findViewById(R.id.vp_pager);
        tabLayout= (TabLayout) findViewById(R.id.vts_id);

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        List<Fragment> fragments = new ArrayList<>();
        OneFragment oneFragment = new OneFragment();
        TwoFragment twoFragment = new TwoFragment();
        ThreeFragment threeFragment = new ThreeFragment();
        fragments.add(oneFragment);
        fragments.add(twoFragment);
        fragments.add(threeFragment);

        //给适配器添加数据


        //tittles的标题集合
        List<String> titles = new ArrayList<String>();
        titles.add("标题1");
        titles.add("标题2");
        titles.add("标题3");
        Log.d("xxx",titles.toString());

        adapter.setFragments(fragments,titles);
        //为Viewpager设置适配器
        tabLayout.setupWithViewPager(vp);
        vp.setAdapter(adapter);

        TabLayout.Tab tab = tabLayout.getTabAt(0);
         //设置显示View
         // tab.setCustomView(R.mipmap.ic_launcher);
        //给tab设置图标
        tab.setIcon(getResources().getDrawable(R.drawable.icon_compass));

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }
    public void showAlterDialog(){
        final AlertDialog.Builder alterDialog=new AlertDialog.Builder(MainActivity.this);
        alterDialog.setCancelable(false);
        //alterDialog.setIcon();//设置图标
        alterDialog.setTitle("消息提示");
        alterDialog.setMessage("你确定要去吗");

        //设置按钮事件
        alterDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"你已确定",Toast.LENGTH_SHORT).show();
            }
        });
        alterDialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"你已取消",Toast.LENGTH_SHORT).show();
            }
        });
        alterDialog.setNegativeButton("还不确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity     .this,"目前还不确定",Toast.LENGTH_SHORT).show();
            }
        });




        alterDialog.show();

    }
    protected void onStart() {
        super.onStart();
        SimpleDateFormat formatter    =   new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss     ");
        Date    curDate    =   new Date(System.currentTimeMillis());
        String    str    =    formatter.format(curDate);
/*        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Log.d("activitylife", "onStart called. "+str);
    }
    protected void onResume() {
        super.onResume();
        SimpleDateFormat formatter    =   new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss     ");
        Date    curDate    =   new Date(System.currentTimeMillis());
        String    str    =    formatter.format(curDate);
/*        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Log.d("activitylife", "onResume called. "+str);
    }
    protected void onPause() {
        super.onPause();
        SimpleDateFormat formatter    =   new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss     ");
        Date    curDate    =   new Date(System.currentTimeMillis());
        String    str    =    formatter.format(curDate);
/*        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Log.d("activitylife", "onPause called. "+str);
    }
    protected void onStop() {
        super.onStop();
        SimpleDateFormat formatter    =   new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss     ");
        Date    curDate    =   new Date(System.currentTimeMillis());
        String    str    =    formatter.format(curDate);
/*        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Log.d("activitylife", "onStop called. "+str);
    }
    protected void onRestart() {
        super.onRestart();
        SimpleDateFormat formatter    =   new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss     ");
        Date    curDate    =   new Date(System.currentTimeMillis());
        String    str    =    formatter.format(curDate);
/*        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Log.d("activitylife", "onRestart called. "+str);
    }
    protected void onDestroy() {
        super.onDestroy();
        SimpleDateFormat formatter    =   new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss     ");
        Date    curDate    =   new Date(System.currentTimeMillis());
        String    str    =    formatter.format(curDate);
/*        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Log.d("activitylife", "onDestroy called. "+str);
    }



}





