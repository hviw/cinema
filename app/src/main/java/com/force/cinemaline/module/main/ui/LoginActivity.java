package com.force.cinemaline.module.main.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseActivity;

/**
 * Created by Administrator on 2016/7/21.
 */
public class LoginActivity extends BaseActivity {
    private ImageView mlogin_back;
    private TextView mlogin_tv_register;
    private TextView mlogin_tv_forget_pwd;

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void findViews() {
        mlogin_back = (ImageView)findViewById(R.id.iv_seting_back);
        mlogin_tv_register = (TextView) findViewById(R.id.login_tx_register);
        mlogin_tv_forget_pwd = (TextView) findViewById(R.id.login_tx_forgot_psw);
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

        mlogin_tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        mlogin_tv_forget_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,ForgetActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
