package com.printsaas.reportapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.printsaas.reportapp.utils.ToastUtils;
import com.printsaas.reportapp.view.BaseActivity;
import com.printsaas.reportapp.view.MainActivity;


/**
 * Created by stone on 2018/5/2.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private ImageView back_image,user_name_delete,pass_word_delete;
    private TextView machine_name,title_name;
    private EditText user_name,pass_word;
    private Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        back_image = (ImageView) findViewById(R.id.login_back_image);
        machine_name = (TextView) findViewById(R.id.login_machine_name);
        title_name = (TextView) findViewById(R.id.login_title_name);

        user_name = (EditText) findViewById(R.id.login_user_name);
        user_name.setFocusable(false);
        pass_word = (EditText) findViewById(R.id.login_pass_word);
        pass_word.setFocusable(false);
        user_name_delete = (ImageView) findViewById(R.id.login_username_delete);
        pass_word_delete = (ImageView) findViewById(R.id.login_pwsd_delete);

        back_image.setOnClickListener(this);
        machine_name.setOnClickListener(this);//这里注意什么时候可以进行 点击。没有进行绑定的时候
        user_name.setOnClickListener(this);
        user_name_delete.setOnClickListener(this);
        pass_word.setOnClickListener(this);
        pass_word_delete.setOnClickListener(this);

        login = (Button) findViewById(R.id.login);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.back_image:
//
//                break;
//            case R.id.machine_name:
//
//                break;
            case R.id.login_user_name:
                user_name.setFocusable(true);
                break;
            case R.id.login_username_delete:
                user_name.getText().clear();

                break;
            case R.id.login_pass_word:
                pass_word.setFocusable(true);
                break;
            case R.id.login_pwsd_delete:
                pass_word.getText().clear();
                break;
            case R.id.login:
                ToastUtils.showToast(LoginActivity.this,"登陆跳转");
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

                break;



        }

    }
}
