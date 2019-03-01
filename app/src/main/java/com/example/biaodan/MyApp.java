package com.example.biaodan;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.lzy.okgo.OkGo;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //blankj:utilcode的初始化
        Utils.init(this);
        OkGo.init(this);

    }
}
