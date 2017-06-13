package com.example.utils.application;

import android.app.Application;
import android.content.Context;

/**
 * Author:cwm
 * DateTime:2017/6/13 22:15
 * Email:chenwm
 * Desc:
 **/
public class App extends Application {

    public static final String TAG = "App";
    private static App app;
    public static Context appContext;


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        appContext = getApplicationContext();


    }

}
