package com.force.cinemaline.module.find.ui;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseFragment;
import com.force.cinemaline.module.find.adapter.MyRecyclerViewAdapter;
import com.force.cinemaline.module.find.bean.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 * 头条
 */
public class HdondFragment extends BaseFragment {


    private RecyclerView mfind_hdong_rsv;

    List<News.NewsListBean> list;
    @Override
    protected int getViewId() {
        return R.layout.fragment_hdong;
    }

    @Override
    protected void findViews(View view) {
        mfind_hdong_rsv = (RecyclerView) view.findViewById(R.id.find_hdong_rsv);
    }

    @Override
    protected void init() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.VERTICAL);

        mfind_hdong_rsv.setLayoutManager(layoutManager);

        list = new ArrayList<>();


        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(list,getContext());
        mfind_hdong_rsv.setAdapter(adapter);
    }


    @Override
    protected void initEvent() {

    }

    @Override
    protected void loadData() {

    }
}
