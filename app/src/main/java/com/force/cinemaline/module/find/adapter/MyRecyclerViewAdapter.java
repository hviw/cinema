package com.force.cinemaline.module.find.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.module.find.bean.News;
import com.squareup.picasso.Picasso;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyHolder> {
    List<News.NewsListBean> mlist;
    Context mcontext;

    public MyRecyclerViewAdapter(List<News.NewsListBean> list, Context context) {
        mlist = list;
        mcontext = context;

    }

    @Override
    public MyRecyclerViewAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.fragment_find_hdong, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.MyHolder holder, int position) {
        News.NewsListBean newsListBean = mlist.get(position);
        try {
            String title = URLDecoder.decode(newsListBean.getTitle(), "UTF-8");
            String content = URLDecoder.decode(newsListBean.getSummary(), "UTF-8");

            holder.mTVTitle.setText(title);
            holder.mTVContent.setText(content);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Picasso.with(mcontext).load(newsListBean.getImgUrl()).into(holder.mImageview);
    }

    @Override
    public int getItemCount() {
        return mlist == null ? 0 : mlist.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView mTVTitle;
        TextView mTVContent;
        ImageView mImageview;

        public MyHolder(View itemView) {
            super(itemView);
            this.mTVTitle = (TextView) itemView.findViewById(R.id.tv_find_news_title);
            this.mTVContent = (TextView) itemView.findViewById(R.id.tv_find_news_content);
            this.mImageview = (ImageView) itemView.findViewById(R.id.find_imv_hdong);


        }
    }
}
