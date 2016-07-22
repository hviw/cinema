package com.force.cinemaline.module.find.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseFragment;
import com.force.cinemaline.module.MyApplication;
import com.force.cinemaline.module.find.adapter.MyRecyclerViewAdapter;
import com.force.cinemaline.module.find.bean.News;
import com.google.gson.Gson;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 * 国内
 */
public class ZxunFragment extends BaseFragment {

    private RecyclerView mfindzxun_rsv;
    List<News.NewsListBean> list;

    MyRecyclerViewAdapter adapter;

    @Override
    protected int getViewId() {
        return R.layout.fragment_zxun;
    }

    @Override
    protected void findViews(View view) {
        mfindzxun_rsv = (RecyclerView) view.findViewById(R.id.find__zxun_rsv);
    }

    @Override
    protected void init() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.VERTICAL);

        mfindzxun_rsv.setLayoutManager(layoutManager);

        list = new ArrayList<>();


        adapter = new MyRecyclerViewAdapter(list,getContext());
        mfindzxun_rsv.setAdapter(adapter);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void loadData() {
        String url = "http://m.189mv.cn/qryNews.htm";

        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("pageNum", "2");
        MyApplication.httpUtils.send(HttpRequest.HttpMethod.POST,
                url,
                requestParams,
                new RequestCallBack<String>() {
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        String result = responseInfo.result;
                        Gson gson = new Gson();
                        News news = gson.fromJson(result, News.class);
                        List<News.NewsListBean> newsList = news.getNewsList();

                        list.addAll(newsList);
                        adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onFailure(HttpException error, String msg) {
                        Log.e("tag", msg);

                    }
                });
    }
}
