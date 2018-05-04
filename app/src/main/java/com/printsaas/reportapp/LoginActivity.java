package com.printsaas.reportapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.printsaas.reportapp.utils.DateUtils;
import com.printsaas.reportapp.utils.ToastUtils;
import com.printsaas.reportapp.view.BaseActivity;
import com.printsaas.reportapp.view.MainActivity;
import com.printsaas.reportapp.view.OrdinaryProductionActivity;


/**
 * Created by stone on 2018/5/2.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back_image, user_name_delete, pass_word_delete;
    private TextView title_name;
    private EditText user_name, pass_word;
    private Button login;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initView() {

        title_name = (TextView) findViewById(R.id.login_title_name);
        String dateTime = DateUtils.getDateTime();
        title_name.setText(dateTime);

        user_name = (EditText) findViewById(R.id.login_user_name);
//        user_name.setFocusable(false);
        pass_word = (EditText) findViewById(R.id.login_pass_word);
//        pass_word.setFocusable(false);
        user_name_delete = (ImageView) findViewById(R.id.login_username_delete);
        pass_word_delete = (ImageView) findViewById(R.id.login_pwsd_delete);

        user_name.setOnClickListener(this);
        user_name_delete.setOnClickListener(this);
        pass_word.setOnClickListener(this);
        pass_word_delete.setOnClickListener(this);

        login = (Button) findViewById(R.id.login);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
                String name = user_name.getText().toString().trim();
                String psw = pass_word.getText().toString().trim();
                if ("1".equals(name) && "1".equals(psw)) {//管理人员登录
                    ToastUtils.showToast(LoginActivity.this, "登陆跳转");
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if ("2".equals(name) && "2".equals(psw)) {//普通员工登录
                    Intent intent = new Intent(LoginActivity.this, OrdinaryProductionActivity.class);
                    startActivity(intent);
                }
                break;


        }

    }
}
