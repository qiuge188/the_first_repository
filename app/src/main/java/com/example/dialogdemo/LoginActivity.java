package com.example.dialogdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText reg_username;
    private EditText reg_password;
    private EditText reg_password2;
    private EditText reg_mail;
    private Button reg_btn_sure;
    private Button reg_btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent=getIntent();
        Bundle data=intent.getExtras();
        reg_username = (EditText) findViewById(R.id.reg_username);
        reg_username.setText(data.getString("reg_username"));
        reg_password = (EditText) findViewById(R.id.reg_password);
        reg_password2 = (EditText) findViewById(R.id.reg_password2);
        reg_mail = (EditText) findViewById(R.id.reg_mail);
        reg_btn_sure = (Button) findViewById(R.id.reg_btn_sure);
        reg_btn_login = (Button) findViewById(R.id.reg_btn_login);
        reg_btn_sure.setOnClickListener(new RegisterButton());
        reg_btn_login.setOnClickListener(new RegisterButton());
        //文本框聚焦
        reg_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    Log.d("mpassword","reg_password.toString()");
                    v.performClick();//调用该控件的单击事件
                }
            }
        });
        //文本内容改变方法
        reg_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i("TAG", "beforeTextChanged: charSequence=" + s + ", start=" + start + ", count=" + count + ", after=" + after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("TAG", "onTextChanged: charSequence=" + s + ", start=" + start + ", before=" + before + ", count=" + count);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i("TAG", "afterTextChanged: editable=" + s);
            }
        });
        //长按监听
        reg_btn_sure.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("长按","onLongClick");
                Toast.makeText(LoginActivity.this,"请注册后登陆",Toast.LENGTH_SHORT).show();
                return false;
            }
        });





    }
    public class RegisterButton implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String username = reg_username.getText().toString().trim();
            String password = reg_password.getText().toString().trim();
            String password2 = reg_password2.getText().toString().trim();
            String mail = reg_mail.getText().toString().trim();
            switch (v.getId()) {
                //注册开始，判断注册条件
                case R.id.reg_btn_sure:
                    if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(password2) || TextUtils.isEmpty(mail)) {
                        Toast.makeText(LoginActivity.this, "各项均不能为空", Toast.LENGTH_SHORT).show();
                    } else {
                        if (TextUtils.equals(password, password2)) {
                            //执行注册操作
                            showAlterDialog();
                            /*Toast.makeText(LoginActivity.this,"注册成功,请返回登录",Toast.LENGTH_SHORT).show();*/
                        } else {
                            Toast.makeText(LoginActivity.this, "两次输入的密码不一样", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
                case R.id.reg_btn_login:
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
            }

        }
    }
    public void showAlterDialog(){
        AlertDialog.Builder alterDialog=new AlertDialog.Builder(LoginActivity.this);
        alterDialog.setCancelable(false);
        //alterDialog.setIcon();//设置图标
        alterDialog.setTitle("消息提示");
        alterDialog.setMessage("您确定注册吗");

        //设置按钮事件
        alterDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(LoginActivity.this,"您注册成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent); 
                Toast.makeText(LoginActivity.this,"注册成功,已返回返回首页",Toast.LENGTH_SHORT).show();
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
                Toast.makeText(LoginActivity.this,"您已取消",Toast.LENGTH_SHORT).show();
            }
        });

        alterDialog.show();

    }
}