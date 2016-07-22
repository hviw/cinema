package com.force.cinemaline.module.detail.ui;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseActivity;
import com.force.cinemaline.module.detail.adapter.StillAdapter;

import java.util.ArrayList;

/**
 * Created by force on 16-7-21.
 */
public class StillActivity extends BaseActivity {

    GridView gridView;
    TextView textViewFileName;
    ImageView imageViewBack;
    ArrayList<String> list;

    @Override
    protected int getContentView() {
        return R.layout.activity_still;
    }

    @Override
    protected void findViews() {
        gridView = (GridView) findViewById(R.id.gv_still_pic_container);
        textViewFileName = (TextView) findViewById(R.id.tv_still_film_name);
        imageViewBack = (ImageView) findViewById(R.id.iv_still_back);
    }

    @Override
    protected void init() {

        Intent intent = getIntent();
        String filmName = intent.getStringExtra("filmName");

        textViewFileName.setText("片花剧照 - " + filmName);

        list = intent.getStringArrayListExtra("picUrls");

        StillAdapter adapter = new StillAdapter(this, list);
        gridView.setAdapter(adapter);
    }

    @Override
    protected void initEvent() {
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();
                intent.setClass(StillActivity.this, GalleryActivity.class);
                intent.putExtra("position", position);
                intent.putStringArrayListExtra("picUrls", list);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
