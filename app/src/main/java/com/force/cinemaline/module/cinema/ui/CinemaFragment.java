package com.force.cinemaline.module.cinema.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseFragment;
import com.force.cinemaline.module.cinema.adApter.MyExpandableListAdapter;
import com.force.cinemaline.module.cinema.bean.CinemaItem;
import com.force.cinemaline.module.main.ui.CityActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by force on 16-7-15.
 */
public class CinemaFragment extends BaseFragment {

    TextView textViewLocation;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //注册EventBus
        EventBus.getDefault().register(this);
    }

    //监听EventBus发送的消息
    @Subscribe
    public void onEventLocation(Intent intent) {
        String location = intent.getStringExtra("location");
        textViewLocation.setText(location);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //取消注册EventBus
        EventBus.getDefault().unregister(this);
    }



    private ExpandableListView expandableListView;
    List<String> listGroup;
    List<List<CinemaItem>> listChildren;

    @Override
    protected int getViewId() {
        return R.layout.fragment_cinemaline;
    }

    @Override
    protected void findViews(View view) {
        expandableListView = (ExpandableListView) view.findViewById(R.id.elv_cinema_container);
        textViewLocation = (TextView) view.findViewById(R.id.tv_cinema_location);
    }

    @Override
    protected void init() {
        initData();
        MyExpandableListAdapter adapter = new MyExpandableListAdapter(getContext(),
                listGroup, listChildren);

        expandableListView.setAdapter(adapter);
    }

    private void initData() {
        listGroup = new ArrayList<>();
        listChildren = new ArrayList<>();

        for (int i = 0; i < 15; i++) {

            listGroup.add(i + "区");

            List<CinemaItem> child = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                CinemaItem cinemaItem = new CinemaItem("影院 " + j, "2" + j, "Add: Street " + j);
                child.add(cinemaItem);
            }

            listChildren.add(child);
        }
    }

    @Override
    protected void initEvent() {
        //对地址栏的监听
        textViewLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CityActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
