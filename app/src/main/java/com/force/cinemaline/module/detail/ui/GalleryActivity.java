package com.force.cinemaline.module.detail.ui;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by force on 16-7-21.
 */
public class GalleryActivity extends BaseActivity {

    ImageView mIVBack;
    ImageView mIVDownload;
    TextView mTVProgress;
    ViewPager mVPContainer;

    List<ImageView> imageViewList;
    ArrayList<String> picUrls;
    private int position;

    @Override
    protected int getContentView() {
        return R.layout.activity_gallery;
    }

    @Override
    protected void findViews() {
        mIVBack = (ImageView) findViewById(R.id.iv_gallery_back);
        mIVDownload = (ImageView) findViewById(R.id.iv_gallery_download);
        mTVProgress = (TextView) findViewById(R.id.tv_gallery_progress);
        mVPContainer = (ViewPager) findViewById(R.id.vp_gallery_container);

    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        picUrls = intent.getStringArrayListExtra("picUrls");
        position = intent.getIntExtra("position", 0);

        imageViewList = new ArrayList<>();
        for (int i = 0; i < picUrls.size(); i++) {
            addImage(picUrls.get(i));

        }

        mVPContainer.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageViewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(imageViewList.get(position));
                return imageViewList.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(imageViewList.get(position));
            }
        });

        //将viewPager定位到传过来的position
        mVPContainer.setCurrentItem(position);

        //设置标题TextView
        mTVProgress.setText(position + 1 + "/" + picUrls.size());
    }

    protected  void addImage(String url){
        ImageView imageView=new ImageView(this);
        Picasso.with(this).load(url).into(imageView);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageViewList.add(imageView);
    }

    @Override
    protected void initEvent() {
        //退出
        mIVBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //viewPager监听
        mVPContainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTVProgress.setText(position + 1 + "/" + picUrls.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mIVDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GalleryActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
