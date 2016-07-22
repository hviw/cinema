package com.force.cinemaline.module.find.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseFragment;
import com.force.cinemaline.module.find.adapter.MyPagerAdapter;
import com.force.cinemaline.module.main.ui.CityActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Administrator on 2016/7/18.
 */
public class FindFragment extends BaseFragment {

    private TabLayout mTab_news;
    private String[] titles;
    private String[] strUrlPramas;
    private Fragment[] fragments;
    private ViewPager mVp_news;

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

    @Override
    protected int getViewId() {
        return R.layout.activity_find;
    }

    @Override
    protected void findViews(View view) {
        textViewLocation = (TextView) view.findViewById(R.id.tv_find_location);
        mTab_news = (TabLayout)view.findViewById(R.id.tab_news);
        mVp_news = (ViewPager)view. findViewById(R.id.vp_news);
        titles = new String[]{"活动", "资讯", "商业优选", "商城", "票房榜",};
        strUrlPramas = new String[]{"huod", "zixun", "sy", "sc", "pf",};
        fragments = new Fragment[titles.length];
        initFragment();
         MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getChildFragmentManager(),fragments);
        mVp_news.setAdapter(myPagerAdapter);
        mVp_news.setOffscreenPageLimit(3);//设置保存的最少页面


        mTab_news.setupWithViewPager(mVp_news);
        mTab_news.setTabMode(TabLayout.MODE_SCROLLABLE);
    }



    private void initFragment() {
        fragments[1] = new ZxunFragment();
        setBundle(1);

        fragments[2]= new YxuanFragment();
        setBundle(2);

        fragments[4] = new PfangFragment();
        setBundle(4);

        fragments[0] = new HdondFragment();
        setBundle(0);

        fragments[3] = new SchengFragment();
        setBundle(3);






    }

    private void setBundle(int num) {
        Bundle bundle = new Bundle();
        bundle.putString("param", strUrlPramas[num]);
        bundle.putString("title", titles[num]);
        fragments[num].setArguments(bundle);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initEvent() {
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
