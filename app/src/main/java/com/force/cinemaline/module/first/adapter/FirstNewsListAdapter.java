package com.force.cinemaline.module.first.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.module.first.bean.NewItem;

import java.util.List;

/**
 * Created by force on 16-7-17.
 */
public class FirstNewsListAdapter extends BaseAdapter {

    Context mContext;
    List<NewItem> list;

    public FirstNewsListAdapter(Context context, List<NewItem> list){
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
        MyHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_first_news,
                    parent, false);
            holder = new MyHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv_first_item_news_logo);
            holder.textViewTitle = (TextView) convertView.findViewById(R.id.tv_first_item_news_title);
            holder.textViewContent = (TextView) convertView.findViewById(R.id.tv_first_item_news_content);

            convertView.setTag(holder);
        } else {
            holder = (MyHolder) convertView.getTag();
        }

        NewItem item = list.get(position);
        holder.imageView.setImageResource(R.mipmap.ic_lunch);
        holder.textViewTitle.setText(item.getNewsTitle());
        holder.textViewContent.setText(item.getNewsContent());

        return convertView;
    }

    class MyHolder {
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewContent;
    }
}
