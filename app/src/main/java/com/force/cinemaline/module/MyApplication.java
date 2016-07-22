package com.force.cinemaline.module;

import android.app.Application;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;

/**
 * Created by force on 16-7-18.
 */
public class MyApplication extends Application {

    public static HttpUtils httpUtils;

    @Override
    public void onCreate() {
        super.onCreate();

        httpUtils = new HttpUtils();
        httpUtils.configRequestThreadPoolSize(4);

    }
}
