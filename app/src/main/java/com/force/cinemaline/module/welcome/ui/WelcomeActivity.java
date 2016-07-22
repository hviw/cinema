package com.force.cinemaline.module.welcome.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseActivity;
import com.force.cinemaline.common.constant.Constant;
import com.force.cinemaline.module.main.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class WelcomeActivity extends BaseActivity {
    private ViewPager mvp_show;
    private Button mbtn_wel;
    private List<ImageView> mlist_image;
    private boolean is_Checked_Logined = false;//判断是否勾选登陆过

    @Override
    protected int getContentView() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void findViews() {
        mvp_show = (ViewPager) findViewById(R.id.vp_ViewPager);
        mbtn_wel= (Button) findViewById(R.id.wel_btn);
    }

    protected  void addImage(int ID){
        ImageView imageView=new ImageView(this);
        imageView.setImageResource(ID);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        mlist_image .add(imageView);
    }
    @Override
    protected void init() {

        checkIfCheckedLoad();
        if (is_Checked_Logined) {
            toMainActivity();
        } else {
            mlist_image = new ArrayList<>();
            addImage(R.mipmap.guide_1_install);
            addImage(R.mipmap.guide_1_upgrade);
            addImage(R.mipmap.guide_2_install);
            addImage(R.mipmap.guide_2_upgrade);
            addImage(R.mipmap.guide_3_install);
            addImage(R.mipmap.guide_3_upgrade);

            mvp_show.setAdapter(new PagerAdapter() {
                @Override
                public int getCount() {
                    return mlist_image.size();
                }

                @Override
                public void destroyItem(ViewGroup container, int position, Object object) {
                    container.removeView((View) object);

                }

                @Override
                public Object instantiateItem(ViewGroup container, int position) {
                    container.addView(mlist_image.get(position));
                    return mlist_image.get(position);
                }

                @Override
                public boolean isViewFromObject(View view, Object object) {
                    return view == object;
                }
            });


        }

    }

    //检查是否第一次登录
    private void checkIfCheckedLoad() {
        SharedPreferences preferences = getSharedPreferences(Constant.APP_NAME, MODE_PRIVATE);
        is_Checked_Logined = preferences.getBoolean(Constant.IS_CHECKED_LOAD, false);
    }

    @Override
    protected void initEvent() {
        mvp_show.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == mlist_image.size() - 1) {
                    mbtn_wel.setVisibility(View.VISIBLE);
                } else {
                    mbtn_wel.setVisibility(View.INVISIBLE);
                }
            }
        });
        mbtn_wel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeCheckedLoad();
                toMainActivity();
            }
        });
    }

    //跳转至主界面
    private void toMainActivity() {
        Intent intent=new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    //第一次登录后向内存中写入数据,记录已经登录
    private void writeCheckedLoad() {
        SharedPreferences preferences = getSharedPreferences(Constant.APP_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(Constant.IS_CHECKED_LOAD, true);
        editor.commit();

    }

    @Override
    protected void loadData() {

    }
}
