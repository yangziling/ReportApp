package com.printsaas.reportapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.printsaas.reportapp.R;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private TextView main_title_name,main_machine_name,login__name;
    private ImageView main_back_image;
    private RecyclerView main_recycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        main_title_name = (TextView) findViewById(R.id.main_title_name);
        main_back_image = (ImageView) findViewById(R.id.main_history_data);
        main_machine_name = (TextView) findViewById(R.id.main_machine_name);
        login__name = (TextView) findViewById(R.id.login__name);
        main_recycleview = (RecyclerView) findViewById(R.id.main_recycleview);

        main_back_image.setOnClickListener(this);//历史任务数据按钮
        main_machine_name.setOnClickListener(this);//这个可以下拉选择机台



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_history_data:
                //历史生产任务
                Intent intent = new Intent(MainActivity.this, HistoryProductionActivity.class);
                startActivity(intent);
                break;
            case R.id.main_machine_name:
                // TODO: 2018/5/3 判定是不是绑定了机台，没有绑定就可以进行机台的切换即可点击

                break;
        }

    }
}
