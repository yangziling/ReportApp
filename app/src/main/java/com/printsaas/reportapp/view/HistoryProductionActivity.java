package com.printsaas.reportapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.printsaas.reportapp.R;

/**
 * Created by stone on 2018/5/3.
 */

public class HistoryProductionActivity extends BaseActivity {

    private ImageView main_history_data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_production);
        main_history_data = (ImageView) findViewById(R.id.main_history_data);
        main_history_data.setImageResource(R.drawable.icon_back_black);
    }
}
