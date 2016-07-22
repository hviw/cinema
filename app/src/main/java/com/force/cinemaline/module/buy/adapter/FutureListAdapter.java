package com.force.cinemaline.module.buy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.module.buy.bean.FutureMovieItem;

import java.util.List;

/**
 * Created by force on 16-7-19.
 */
public class FutureListAdapter extends BaseAdapter {

    Context context;
    List<FutureMovieItem> list;

    public FutureListAdapter(Context context, List<FutureMovieItem> list) {
        this.context = context;
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
        MyHolder myHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_buy_movie_future,
                   parent, false);

            myHolder = new MyHolder();
            myHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_movie_future_logo);
            myHolder.textViewTitle = (TextView) convertView.findViewById(R.id.tv_movie_future_title);
            myHolder.textViewActor = (TextView) convertView.findViewById(R.id.tv_movie_future_actor);
            myHolder.textViewContent = (TextView) convertView.findViewById(R.id.tv_movie_future_content);
            myHolder.textViewDate = (TextView) convertView.findViewById(R.id.tv_movie_future_date);

            convertView.setTag(myHolder);
        } else {
            myHolder = (MyHolder) convertView.getTag();
        }

        FutureMovieItem item = list.get(position);
        myHolder.imageView.setImageResource(item.getResId());
        myHolder.textViewTitle.setText(item.getTitle());
        myHolder.textViewActor.setText(item.getActors());
        myHolder.textViewContent.setText(item.getContent());
        myHolder.textViewDate.setText(item.getDate());

        return convertView;
    }

    class MyHolder{
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewActor;
        TextView textViewContent;
        TextView textViewDate;
    }
}
