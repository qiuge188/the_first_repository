package com.example.dialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity {

    private Button btn_pb;
    private Button btn_pb_add;
    private Button btn_pb_remove;
    ProgressBar pb6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        btn_pb=(Button)findViewById(R.id.btn_pb);
        btn_pb_add=(Button)findViewById(R.id.btn_pb_add);
        btn_pb_remove=(Button)findViewById(R.id.btn_pb_remove) ;
        pb6=(ProgressBar)findViewById(R.id.pb6);
/*        requestWindowFeature(Window.FEATURE_PROGRESS);// 进度指示器功能
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS); // 不确定的进度*/
        btn_pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_pb.getText().toString().equals("隐藏")||pb6.getVisibility()==View.VISIBLE){
                     //设为隐藏
                    pb6.setVisibility(View.GONE);
                    btn_pb.setText("显示");
                }else{
                    //显示
                    pb6.setVisibility(View.VISIBLE);
                    btn_pb.setText("隐藏");
                }
            }
        });
        btn_pb_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb6.incrementProgressBy(10);

            }
        });
        btn_pb_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb6.incrementProgressBy(-10);
            }
        });
    }
}