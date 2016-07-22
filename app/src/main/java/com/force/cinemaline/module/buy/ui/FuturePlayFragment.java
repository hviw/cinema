package com.force.cinemaline.module.buy.ui;

import android.view.View;
import android.widget.ListView;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseFragment;
import com.force.cinemaline.module.buy.adapter.FutureListAdapter;
import com.force.cinemaline.module.buy.bean.FutureMovieItem;

import java.util.ArrayList;
import java.util.List;

public class FuturePlayFragment extends BaseFragment {

    ListView listView;

    @Override
    protected int getViewId() {
        return R.layout.fragment_buy_movie_future;
    }

    @Override
    protected void findViews(View view) {
        listView = (ListView) view.findViewById(R.id.lv_movie_future_container);
    }

    List<FutureMovieItem> list;

    @Override
    protected void init() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            FutureMovieItem item = new FutureMovieItem(R.mipmap.aaaa, "" + i, "-----" + i, "@@@@" + i, "DDDD" + i);
            list.add(item);
        }
        FutureListAdapter adapter = new FutureListAdapter(getContext(), list);
        listView.setAdapter(adapter);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void loadData() {

    }
}
