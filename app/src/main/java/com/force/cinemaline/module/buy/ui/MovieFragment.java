package com.force.cinemaline.module.buy.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ListView;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseFragment;
import com.force.cinemaline.module.buy.adapter.MoviePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by force on 16-7-18.
 */
public class MovieFragment extends BaseFragment {

    TabLayout tabLayout;
    ViewPager movieViewPager;
    List<Fragment> fragments;

    String[] titles;

    @Override
    protected int getViewId() {
        return R.layout.fragment_buy_movie;
    }

    @Override
    protected void findViews(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tl_buy_movie);
        movieViewPager = (ViewPager) view.findViewById(R.id.vp_buy_movie_container);
    }

    @Override
    protected void init() {
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        initViewPager();

        tabLayout.setupWithViewPager(movieViewPager);
    }

    private void initViewPager() {
        titles = new String[] {"正在热映", "即将上映"};

        fragments = new ArrayList<>();
        FuturePlayFragment futurePlayFragment = new FuturePlayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", titles[1]);
        futurePlayFragment.setArguments(bundle);

        NowPlayFragment nowPlayFragment = new NowPlayFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("title", titles[0]);
        nowPlayFragment.setArguments(bundle1);

        fragments.add(nowPlayFragment);
        fragments.add(futurePlayFragment);


        PagerAdapter adapter = new MoviePagerAdapter(getFragmentManager(), fragments);
        movieViewPager.setAdapter(adapter);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void loadData() {

    }
}
