package com.force.cinemaline.module.me.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseFragment;
import com.force.cinemaline.module.main.ui.LoginActivity;
import com.force.cinemaline.module.setup.ui.SetingActivity;

/**
 * Created by force on 16-7-15.
 */
public class MeFragment extends BaseFragment {

    private ImageView mme_title_seting;
    private ImageView miv_seting_back;
    private ImageView mlogin_tx;
    private TextView mlogin_dl;


    @Override
    protected int getViewId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void findViews(View view) {
        mme_title_seting = (ImageView) view.findViewById(R.id.me_title_seting);
        miv_seting_back = (ImageView) view.findViewById(R.id.iv_seting_back);
        mlogin_tx = (ImageView) view.findViewById(R.id.fragment_me_tx);
        mlogin_dl = (TextView) view.findViewById(R.id.fragment_me_dl);

    }

    @Override
    protected void init() {

    }

    @Override
    protected void initEvent() {
        mme_title_seting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), SetingActivity.class);
                startActivity(intent);
            }
        });

        mlogin_tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        mlogin_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void loadData() {

    }
}
