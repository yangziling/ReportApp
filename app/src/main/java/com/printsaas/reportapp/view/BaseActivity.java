package com.printsaas.reportapp.view;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.printsaas.reportapp.utils.ToastUtils;

/**
 * Created by stone on 2018/5/2.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
           ToastUtils.showToast(this,"当前屏幕为横屏");
        } else {
            ToastUtils.showToast(this,"当前屏幕为竖屏");
        }
        super.onConfigurationChanged(newConfig);
    }
}
