package com.example.johan007.saoma;

import android.app.Application;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by Johan007 on 2017/6/2.
 */

public class MyApplication extends Application {
    public static MyApplication context;
    @Override
    public void onCreate() {
        super.onCreate();
        if (context == null) {
            context = this;
        }
        ZXingLibrary.initDisplayOpinion(this);
    }
}
