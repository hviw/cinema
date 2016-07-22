package com.force.cinemaline.module.find.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.force.cinemaline.R;

import java.util.List;

/**
 * Created by Administrator on 2016/7/19
 */
public class MyPfangRecycleeviewAdapter extends RecyclerView.Adapter<MyPfangRecycleeviewAdapter.MyHolder> {
    List<String> mlist;
    Context mcontext;

    public MyPfangRecycleeviewAdapter(List<String> list, Context context) {
        mlist = list;
        mcontext = context;

    }

    @Override
    public MyPfangRecycleeviewAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.fragment_find_pfang, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyPfangRecycleeviewAdapter.MyHolder holder, int position) {
        holder.mtitle.setText(mlist.get(position));
        holder.mtvup.setText(mlist.get(position));
        holder.mtvup1.setText(mlist.get(position));
        holder.mtvdown.setText(mlist.get(position));
        holder.mtvdown1.setText(mlist.get(position));

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void addItem(List<String> newDatas) {
        newDatas.addAll(mlist);
        mlist.removeAll(mlist);
        mlist.addAll(newDatas);
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView mimageView;
        TextView mtitle;
        TextView mtvup;
        TextView mtvup1;
        TextView mtvdown;
        TextView mtvdown1;

        public MyHolder(View itemView) {
            super(itemView);
          mimageView = (ImageView) itemView.findViewById(R.id.find_pfang_imv);
           mtitle = (TextView) itemView.findViewById(R.id.find_pfang_tvtitle);
           mtvup = (TextView) itemView.findViewById(R.id.find_pfang_tvup);
           mtvup1 = (TextView) itemView.findViewById(R.id.find_pfang_tvup1);
           mtvdown = (TextView) itemView.findViewById(R.id.find_pfang_tvdown);
            mtvdown1 = (TextView) itemView.findViewById(R.id.find_pfang_tvdown1);

        }
    }
}
