package com.printsaas.reportapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.printsaas.reportapp.R;

/**
 * Created by stone on 2018/5/3.
 */

public class ManagementSettingActivity extends BaseActivity {

    private TextView management_machine_name;
    private RadioButton yes,no;
    private Button save;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_setting);
        initView();
    }

    private void initView() {
        management_machine_name = (TextView) findViewById(R.id.management_machine_name);
        yes = (RadioButton) findViewById(R.id.yes);
        no = (RadioButton) findViewById(R.id.no);
        save = (Button) findViewById(R.id.save);
    }
}
