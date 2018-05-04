package com.printsaas.reportapp.utils;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Date;

/**
 * Created by stone on 2018/5/3.
 */

public class DateUtils {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String getDateTime(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = dateFormat.format(date);
        return format;
    }
}
