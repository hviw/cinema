package com.force.cinemaline.module.detail.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.force.cinemaline.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by force on 16-7-21.
 */
public class MyHorizontalAdapter {

    private Context mContext;
    private List<String> mPicUrls;

    public MyHorizontalAdapter(Context context, List<String> picUrls) {
        this.mContext = context;
        this.mPicUrls = picUrls;
    }

    public int getCount() {
        return mPicUrls == null? 0 : mPicUrls.size();
    }

    public Object getItem(int position) {
        return mPicUrls.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        PicHolder picHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_detail_pic,
                    parent, false);

            picHolder = new PicHolder();
            picHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_detail_pic_item);

            convertView.setTag(picHolder);
        } else {
            picHolder = (PicHolder) convertView.getTag();
        }

        String picUrl = mPicUrls.get(position);
        Picasso.with(mContext).load(picUrl).into(picHolder.imageView);

        convertView.measure(0, 0);
        int measuredHeight = convertView.getMeasuredHeight();

        Log.e("tag", "=-=========-----" + measuredHeight);
        return convertView;
    }

    class PicHolder{
        ImageView imageView;
    }
}
