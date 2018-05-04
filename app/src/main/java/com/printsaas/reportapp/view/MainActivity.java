package com.printsaas.reportapp.view;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.printsaas.reportapp.R;
import com.printsaas.reportapp.adapter.ProductionListAdapter;
import com.printsaas.reportapp.bean.ProductionBean;
import com.printsaas.reportapp.bean.SpaceItemDecoration;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView main_title_name, main_machine_name,
        login__name,management;
    private ImageView main_back_image;
    private RecyclerView main_recycleview;
    private static ArrayList<ProductionBean> productionList;

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
        //设置下划线textview
        management = (TextView) findViewById(R.id.management);
        management.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG);
        management.getPaint().setAntiAlias(true);//抗锯齿
        management.setText(Html.fromHtml(""+"后台管理"+""));
        management.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManagementSettingActivity.class);
                startActivity(intent);
            }
        });

        login__name = (TextView) findViewById(R.id.login__name);

        main_recycleview = (RecyclerView) findViewById(R.id.main_recycleview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        main_recycleview.setLayoutManager(linearLayoutManager);

        ProductionListAdapter productionListAdapter = new ProductionListAdapter(MainActivity.this, productionList);
        main_recycleview.addItemDecoration(new SpaceItemDecoration(20));//设置item间隔
        main_recycleview.setAdapter(productionListAdapter);

        main_back_image.setOnClickListener(this);//历史任务数据按钮
        main_machine_name.setOnClickListener(this);//这个可以下拉选择机台

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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

    static {
        productionList = new ArrayList<ProductionBean>();
        for (int i = 0; i < 20; i++) {
            ProductionBean productionBean = new ProductionBean();
            productionBean.setProductId("SXN101389012:" + i);
            productionBean.setProductName("XXXXX画册:" + i);
            productionBean.setProducessName1("内页" + i);
            productionBean.setProducessName2("镀金" + i);
            productionBean.setStartTime("2018-05-03 " + i);
            productionBean.setEndTime("2018-05-30 " + i);
            productionList.add(productionBean);
        }
    }
}
