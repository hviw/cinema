package com.force.cinemaline.module.setup.ui;

import android.view.View;
import android.widget.ImageView;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseActivity;

/**
 * Created by Administrator on 2016/7/20.
 */
public class Help extends BaseActivity {
    private ImageView miv_Seting_back;
    @Override
    protected int getContentView() {
        return R.layout.activity_help;
    }

    @Override
    protected void findViews() {
        miv_Seting_back = (ImageView) findViewById(R.id.iv_seting_back);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initEvent() {
        miv_Seting_back.setOnClickListener(new View.OnClickListener() {
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
