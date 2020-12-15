package com.example.dialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RecyclerViewActivity extends AppCompatActivity {
    private CheckBox ckOK;
    private LinearLayout Linear;
    private RadioGroup LinearRadio;
    private Button btn_sub;
    private  Button btn_sub_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ckOK= (CheckBox) findViewById(R.id.tongyi);
        Linear= (LinearLayout) findViewById(R.id.Linear);
        LinearRadio=(RadioGroup)findViewById(R.id.LinearRadio);
        btn_sub= (Button) findViewById(R.id.btn_sub);
        btn_sub_2= (Button) findViewById(R.id.btn_sub_2);
        ckOK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ckOK.setText("已同意");
                }
                else
                    ckOK.setText("同意");
            }
        });


        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer sb=new StringBuffer();
                int cNum=Linear.getChildCount();
                for(int i=0;i<cNum;i++){
                    CheckBox cb=(CheckBox)Linear.getChildAt(i);
                    if(cb.isChecked()){
                        sb.append(cb.getText().toString());
                    }
                }
                Toast.makeText(RecyclerViewActivity.this, sb.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        btn_sub_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int cNum=Linear.getChildCount();
                for(int i=0;i<cNum;i++){
                    RadioButton rb=(RadioButton)LinearRadio.getChildAt(i);
                    if(rb.isChecked()){
                        Toast.makeText(RecyclerViewActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}