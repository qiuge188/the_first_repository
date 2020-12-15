package com.example.dialogdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThreeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThreeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int choice;
    ArrayList<Integer> choices= new ArrayList<>();

    public ThreeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThreeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThreeFragment newInstance(String param1, String param2) {
        ThreeFragment fragment = new ThreeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View view =  inflater.inflate(R.layout.fragment_three, container, false);
        Button button3 = (Button) view.findViewById(R.id.button3);
        Button button4 =(Button) view.findViewById(R.id.button4);
        Log.d("ddd","123");
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开对话框
                Log.d("xxxx","打开对话框");
                showSingDialog();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开对话框
                Log.d("xxxx","打开对话框");
                showMultiChoiceDialog();
            }
        });
        return view;
    }

    private void showSingDialog() {
        final String[] items = {"我是1","我是2","我是3"};
        AlertDialog.Builder singleChoiceDialog = new AlertDialog.Builder(getContext());
//        singleChoiceDialog.setIcon(R.drawable.icon);
        singleChoiceDialog.setTitle("我是单选Dialo");
        //第二个参数是默认的选项
        singleChoiceDialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choice= which;
            }
        });
        singleChoiceDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (choice!=-1){
                    Toast.makeText(getContext(),
                            "你选择了" + items[choice],
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        singleChoiceDialog.create();
        singleChoiceDialog.show();
    }

    final boolean initchoices[] = {false,false,false};
    private void showMultiChoiceDialog(){
        final String[] items = {"我是1","我是2","我是3"};
        //设置默认选择都是false
       /* final boolean initchoices[] = {false,false,false};*/
        choices.clear();
        AlertDialog.Builder multChoiceDialog = new AlertDialog.Builder(getContext());
        //multChoiceDialog.setIcon(R.drawable.icon);
        multChoiceDialog.setTitle("我是个多选Dialog");

        multChoiceDialog.setMultiChoiceItems(items, initchoices, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked){
                    Log.d("add", String.valueOf(which));
                    initchoices[which]=true;
                    /*choices.add(which);*/
                }else {
                    initchoices[which]=false;
                    /*choices.remove(which);*/

                }
            }
        });
        multChoiceDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int size = initchoices.length;
                String str = "";
                for(int i = 0;i<size;i++){
                    if(initchoices[i]==true){
                        str+=items[i]+"";
                    }
                }
                Toast.makeText(getContext(),
                        "你选中了" + str,
                        Toast.LENGTH_SHORT).show();
            }
        });
        multChoiceDialog.create();
        multChoiceDialog.show();
    }
}