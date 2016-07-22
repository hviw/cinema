package com.force.cinemaline.module.buy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseFragment;
import com.force.cinemaline.module.buy.adapter.BuyRootPagerAdapter;
import com.force.cinemaline.module.main.ui.CityActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by force on 16-7-15.
 */
public class BuyFragment extends BaseFragment {

    ViewPager viewPager;
    List<Fragment> rootFragments;
    RadioGroup rootRadioGroup;

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
        return R.layout.fragment_buy;
    }

    @Override
    protected void findViews(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.vp_buy_container);
        rootRadioGroup = (RadioGroup) view.findViewById(R.id.rg_buy_root);
        textViewLocation = (TextView) view.findViewById(R.id.tv_buy_location);
    }

    @Override
    protected void init() {
        rootFragments = new ArrayList<>();
        MovieFragment movieFragment = new MovieFragment();
        ShowFragment showFragment = new ShowFragment();

        rootFragments.add(movieFragment);
        rootFragments.add(showFragment);

        BuyRootPagerAdapter rootPagerAdapter = new BuyRootPagerAdapter(getFragmentManager(), rootFragments);
        viewPager.setAdapter(rootPagerAdapter);
    }

    @Override
    protected void initEvent() {
        rootRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_buy_movie:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_buy_show:
                        viewPager.setCurrentItem(1);
                        break;
                    default:
                        break;
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                RadioButton radioButton = null;
                switch (position) {
                    case 0:
                        radioButton = (RadioButton) rootRadioGroup.getChildAt(0);
                        break;
                    case 1:
                        radioButton = (RadioButton) rootRadioGroup.getChildAt(1);
                        break;
                    default:
                        break;
                }
                radioButton.setChecked(true);;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //对地址栏进行监听
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
