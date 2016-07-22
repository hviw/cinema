package com.force.cinemaline.module.main.ui;

import android.view.View;
import android.widget.ImageView;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseActivity;

/**
 * Created by Administrator on 2016/7/21.
 */
public class RegisterActivity extends BaseActivity{
    private ImageView mlogin_back;
    @Override
    protected int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    protected void findViews() {
        mlogin_back = (ImageView)findViewById(R.id.iv_seting_back);

    }

    @Override
    protected void init() {

    }

    @Override
    protected void initEvent() {
        mlogin_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
