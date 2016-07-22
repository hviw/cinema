package com.force.cinemaline.module.buy.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseFragment;
import com.force.cinemaline.module.buy.adapter.ShowRecyclerAdapter;
import com.force.cinemaline.module.buy.bean.ShowData;

import java.util.ArrayList;
import java.util.List;

public class ShowFragment extends BaseFragment {

    RecyclerView recyclerView;
    List<ShowData> listData;

    @Override
    protected int getViewId() {
        return R.layout.fragment_buy_show;
    }

    @Override
    protected void findViews(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_show_container);
    }

    @Override
    protected void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        listData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ShowData data = new ShowData(R.mipmap.aaaa, i + "", "2016.08." + i,
                    "TongDon Street " + i, i + 10);
            listData.add(data);
        }

        ShowRecyclerAdapter adapter = new ShowRecyclerAdapter(getContext(), listData);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void loadData() {

    }
}
