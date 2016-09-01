package com.nightfarmer.themelib.sample;

import android.app.Application;

import com.nightfarmer.themelib.ThemeLib;

/**
 * Created by zhangfan on 16-8-31.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ThemeLib.init(this, R.style.def);
    }
}
