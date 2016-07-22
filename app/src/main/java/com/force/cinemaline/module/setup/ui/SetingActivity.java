package com.force.cinemaline.module.setup.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseActivity;
import com.force.cinemaline.module.setup.ui.view.SlideSwitchButton;

/**
 * Created by Administrator on 2016/7/20.
 */
public class SetingActivity extends BaseActivity {

    private ImageView miv_Seting_back;
    private TextView mtv_seting_share;
    private TextView mtv_seting_help;
    private TextView mtv_seting_feedback;
    private TextView mtv_seting_aboutus;
    private SlideSwitchButton mslidebutten;

    @Override
    protected int getContentView() {
        return R.layout.activity_seting;
    }

    @Override
    protected void findViews() {
        miv_Seting_back = (ImageView) findViewById(R.id.iv_seting_back);
        mtv_seting_share = (TextView) findViewById(R.id.seting_share);
        mtv_seting_help = (TextView) findViewById(R.id.seting_help);
        mtv_seting_feedback = (TextView) findViewById(R.id.seting_feedback);
        mtv_seting_aboutus = (TextView) findViewById(R.id.seting_aboutus);
        mslidebutten = (SlideSwitchButton) findViewById(R.id.slideview);

    }

    @Override
    protected void init() {
          SlideSwitchButton.OnStateChangedListener listener=new SlideSwitchButton.OnStateChangedListener() {
              @Override
              public void onStateChanged(boolean on) {
                  if (on) {
                      Toast.makeText(SetingActivity.this, "打开了",Toast.LENGTH_LONG).show();
                  }
                  else{
                      Toast.makeText(SetingActivity.this, "关闭了",Toast.LENGTH_LONG).show();
                  }

              }
          };
           mslidebutten.setOnStateChangedListener(listener);
    }

    @Override
    protected void initEvent() {
        miv_Seting_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mtv_seting_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SetingActivity.this,Shareseting.class);
                startActivity(intent);
            }
        });

        mtv_seting_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SetingActivity.this,Help.class);
                startActivity(intent);
            }
        });

        mtv_seting_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SetingActivity.this,Feedback.class);
                startActivity(intent);
            }
        });
        mtv_seting_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SetingActivity.this,Aboutus.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
