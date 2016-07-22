package com.force.cinemaline.module.find.ui;


import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;


import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseFragment;
import com.force.cinemaline.module.find.adapter.MyPfangRecycleeviewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 * 头条
 */
public class PfangFragment extends BaseFragment {


    private RecyclerView mpfang_rsv;
    List<String> list;
    private SwipeRefreshLayout mfind_pfang_swresh;
    private MyPfangRecycleeviewAdapter adapter;

    @Override
    protected int getViewId() {
        return R.layout.fragment_pfang;
    }

    @Override
    protected void findViews(View view) {
        mpfang_rsv = (RecyclerView) view.findViewById(R.id.find_pfang_rsv);
        mfind_pfang_swresh = (SwipeRefreshLayout) view.findViewById(R.id.find_pfang_swrefreshlayout);
        mfind_pfang_swresh.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
    }

    @Override
    protected void init() {
        mfind_pfang_swresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                  new Handler().postDelayed(new Runnable() {
                      @Override
                      public void run() {
                          List<String> newDatas = new ArrayList<String>();
                          for (int i = 0; i <5; i++) {
                              int index = i + 1;
                              newDatas.add("new item" + index);
                          }
                          adapter.addItem(newDatas);
                          mfind_pfang_swresh.setRefreshing(false);
                          Toast.makeText(getContext(), "更新了五条数据...", Toast.LENGTH_SHORT).show();
                      }
                  },3000);
            }
        });



        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.VERTICAL);
        mpfang_rsv.setLayoutManager(layoutManager);

        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }

        adapter = new MyPfangRecycleeviewAdapter(list,getContext());
        mpfang_rsv.setAdapter(adapter);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void loadData() {

    }
}
