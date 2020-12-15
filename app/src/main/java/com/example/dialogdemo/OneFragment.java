package com.example.dialogdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;

/*import android.support.v7.app.AlertDialog;*/
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class OneFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button button1;
    Button btn_res;
    Button btn_iv;
    Button btn_show;
    Button btn_progress_bar;

    public OneFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static OneFragment newInstance(String param1, String param2) {
        OneFragment fragment = new OneFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onAttach(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_one, container, false);
       button1 = (Button) view.findViewById(R.id.button1);
       btn_res=(Button)view.findViewById(R.id.btn_res);
       btn_iv=(Button)view.findViewById(R.id.btn_iv);
       btn_show=(Button)view.findViewById(R.id.btn_show) ;
       btn_progress_bar=(Button)view.findViewById(R.id.btn_progress_bar);
        Log.d("ddd","OneFragment");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开对话框
                Log.d("xxxx","打开对话框");
                showAlterDialog();
            }
        });
        btn_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),LoginActivity.class);
                /*intent.putExtra("reg_username","qiuge");*/
                Bundle bundle=new Bundle();
                bundle.putString("reg_username","qiuge");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btn_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("imageview","打开Image View");
                Intent intent = new Intent(getContext(),ImageView.class);
                startActivity(intent);
            }
        });
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),ButtonActivity.class);
                startActivity(intent);
            }
        });
        btn_progress_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),ProgressBarActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    public void showAlterDialog(){
        AlertDialog.Builder alterDialog=new AlertDialog.Builder(getContext());
        //取消点击对话框外面对话框消失
        alterDialog.setCancelable(false);
        //alterDialog.setIcon();//设置图标
        alterDialog.setTitle("消息提示");
        alterDialog.setMessage("你确定要去吗");

        //设置按钮事件
        alterDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"你已确定",Toast.LENGTH_SHORT).show();
            }
        });

  /*      alterDialog.setNegativeButton("还不确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"目前还不确定",Toast.LENGTH_SHORT).show();
            }
        });*/
        alterDialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"你已取消",Toast.LENGTH_SHORT).show();
            }
        });

        /*alterDialog.create();*/
        alterDialog.show();

    }
}