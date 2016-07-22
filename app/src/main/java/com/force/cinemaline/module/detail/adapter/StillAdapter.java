package com.force.cinemaline.module.detail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.force.cinemaline.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by force on 16-7-21.
 */
public class StillAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<String> list;

    public StillAdapter(Context context, ArrayList<String> list) {
        this.mContext = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StillPicHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_still_pic,
                    parent, false);

            holder = new StillPicHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv_still_pic);

            convertView.setTag(holder);
        } else {
            holder = (StillPicHolder) convertView.getTag();
        }

        String url = list.get(position);
        Picasso.with(mContext).load(url).into(holder.imageView);
        return convertView;
    }

    class StillPicHolder{
        ImageView imageView;
    }
}
