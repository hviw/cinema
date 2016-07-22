package com.force.cinemaline.module.first.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseFragment;
import com.force.cinemaline.common.constant.Constant;
import com.force.cinemaline.module.MyApplication;
import com.force.cinemaline.module.first.adapter.FirstNewsListAdapter;
import com.force.cinemaline.module.first.adapter.FirstRecyclerAdapter;
import com.force.cinemaline.module.first.bean.NewItem;
import com.force.cinemaline.module.first.bean.TodayMovieItem;
import com.force.cinemaline.module.main.ui.CityActivity;
import com.force.cinemaline.module.main.ui.MainActivity;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends BaseFragment {

    RecyclerView mRecyclerView;
    List<NewItem> listNews;
    TextView mTextViewCommentMore;
    TextView mTextViewEventMore;
    ListView mListNews;
    TextView mTextViewCinemaMore;
    TextView mTextViewNewsMore;

    TextView textViewLocation;

    List<TodayMovieItem.ResultBean> resultBeanList = new ArrayList<>();

    private String movieUrl = "http://v.juhe.cn/movie/movies.today";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //注册EventBus进行监听
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //取消注册EventBus
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_first;
    }

    @Override
    protected void findViews(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_first_recommend);
        mTextViewCommentMore = (TextView) view.findViewById(R.id.tv_first_more);
        mTextViewEventMore = (TextView) view.findViewById(R.id.tv_first_event_more);
        mListNews = (ListView) view.findViewById(R.id.lv_first_news_container);
        mTextViewCinemaMore = (TextView) view.findViewById(R.id.tv_first_cinema_more);
        mTextViewNewsMore = (TextView) view.findViewById(R.id.tv_first_news_more);
        textViewLocation = (TextView) view.findViewById(R.id.tv_first_location);
    }

    FirstRecyclerAdapter recyclerAdapter;

    @Override
    protected void init() {
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        mRecyclerView.setLayoutManager(manager);

        recyclerAdapter = new FirstRecyclerAdapter(getContext(), resultBeanList);
        mRecyclerView.setAdapter(recyclerAdapter);

        //初始化listView
        initListNews();
        FirstNewsListAdapter listAdapter = new FirstNewsListAdapter(getContext(), listNews);
        mListNews.setAdapter(listAdapter);
    }

    //初始化咨询列表
    private void initListNews() {
        listNews = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            NewItem item = new NewItem("null", "---" + i, "----------" + i);
            listNews.add(item);
        }
    }


    MainActivity mainActivity;
    @Override
    protected void initEvent() {
        mainActivity = (MainActivity) getActivity();

        //推荐更多的监听
        mTextViewCommentMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.toBuyFragment();
            }
        });

        //热门活动更多的监听
        mTextViewEventMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.toFindFragment();
            }
        });

        //推荐影院更多的监听
        mTextViewCinemaMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.toCinemaFragment();
            }
        });

        textViewLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CityActivity.class);
                startActivity(intent);
            }
        });
    }

    //监听EventBus发送的消息
    @Subscribe
    public void onEventLocation(Intent intent) {
        String location = intent.getStringExtra("location");
        textViewLocation.setText(location);
    }

    @Override
    protected void loadData() {

//        RequestParams requestParams = new RequestParams();
//        requestParams.addBodyParameter("key", Constant.APP_KEY);
//        requestParams.addBodyParameter("cityid", "3");
//
//        MyApplication.httpUtils.send(HttpRequest.HttpMethod.POST,
//                movieUrl, requestParams, new RequestCallBack<String>() {
//                    @Override
//                    public void onSuccess(ResponseInfo<String> responseInfo) {
//                        String result = responseInfo.result;
//
//                        Gson gson = new Gson();
//                        TodayMovieItem movieItem = gson.fromJson(result, TodayMovieItem.class);
//                        List<TodayMovieItem.ResultBean> resultBeen = movieItem.getResult();
//                        resultBeanList.addAll(resultBeen);
//
//                        recyclerAdapter.notifyDataSetChanged();
//                        Log.e("@@@@@@@@@@@@@@tag", result);
//                    }
//
//                    @Override
//                    public void onFailure(HttpException error, String msg) {
//
//                    }
//                });
    }
}
