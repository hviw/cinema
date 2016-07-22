package com.force.cinemaline.base;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

        findViews();
        init();
        initEvent();
        loadData();
    }


    /**
     * 初始化布局
     * @return
     */
    protected abstract int getContentView();

    /**
     * 寻找控件
     */
    protected abstract void findViews();

    /**
     * 初始化数据
     */
    protected abstract void init();

    /**
     * 初始化事件监听
     */
    protected abstract void initEvent();

    /**
     * 加载数据
     */
    protected abstract void loadData();
}
