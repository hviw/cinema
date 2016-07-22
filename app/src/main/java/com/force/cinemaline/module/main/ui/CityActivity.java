package com.force.cinemaline.module.main.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseActivity;
import com.force.cinemaline.common.constant.Constant;
import com.force.cinemaline.module.main.adapter.CityExpandableAdapter;
import com.force.cinemaline.module.main.bean.City;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by force on 16-7-19.
 */
public class CityActivity extends BaseActivity {

    LocalBroadcastManager manager;

    ExpandableListView expandableListView;
    List<City.ChinaBean> list = new ArrayList<>();

    ImageView imageViewBack;
    private MyLocalReceiver receiver;

    @Override
    protected int getContentView() {
        return R.layout.activity_city;
    }

    @Override
    protected void findViews() {
        expandableListView = (ExpandableListView) findViewById(R.id.elv_city_container);
        imageViewBack = (ImageView) findViewById(R.id.iv_city_back);

        //注册本地广播
        manager = LocalBroadcastManager.getInstance(this);
        this.receiver = new MyLocalReceiver();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constant.APP_KEY);
        manager.registerReceiver(receiver, intentFilter);
    }

    CityExpandableAdapter adapter;

    @Override
    protected void init() {
        adapter = new CityExpandableAdapter(this, list);
        expandableListView.setAdapter(adapter);
    }

    @Override
    protected void initEvent() {
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }

    public void sendResult(Intent intent) {
        setResult(Constant.RESULT_OK, intent);

        EventBus.getDefault().post(intent);
        finish();
    }

    @Override
    protected void loadData() {
        Gson gson = new Gson();
        City city = gson.fromJson(Constant.CITYS, City.class);
        List<City.ChinaBean> china = city.getChina();

        list.addAll(china);
        adapter.notifyDataSetChanged();

    }

    //自定义本地广播
    private class MyLocalReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String location = intent.getStringExtra("location");
            if (!location.equals("null")) {
                Intent intentResult = new Intent();
                intentResult.putExtra("location", location);
                sendResult(intentResult);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //取消注册的接收器
        manager.unregisterReceiver(receiver);
    }
}
