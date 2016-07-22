package com.force.cinemaline.module.buy.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseFragment;
import com.force.cinemaline.module.buy.adapter.NowPlayRecyclerAdapter;
import com.force.cinemaline.module.buy.bean.NowPlayMovie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by force on 16-7-19.
 */
public class NowPlayFragment extends BaseFragment {

    RecyclerView recyclerView;

    @Override
    protected int getViewId() {
        return R.layout.fragment_buy_movie_now;
    }

    @Override
    protected void findViews(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_buy_movie_now);
    }

    List<NowPlayMovie> list;
    @Override
    protected void init() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            NowPlayMovie x = new NowPlayMovie(R.mipmap.aaaa, "X", "Smith / Jane", "Hello world", "5.6");
            list.add(x);
        }
        NowPlayRecyclerAdapter adapter = new NowPlayRecyclerAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void initEvent() {
    }

    @Override
    protected void loadData() {

    }
}
