package com.force.cinemaline.module.buy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.module.buy.bean.ShowData;

import java.util.List;

/**
 * Created by force on 16-7-19.
 */
public class ShowRecyclerAdapter extends RecyclerView.Adapter<ShowRecyclerAdapter.ShowHolder> {

    Context context;
    List<ShowData> list;

    public ShowRecyclerAdapter(Context context, List<ShowData> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ShowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_show,
                parent, false);

        ShowHolder holder = new ShowHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ShowHolder holder, int position) {
        ShowData data = list.get(position);

        holder.imageView.setImageResource(data.getResId());
        holder.textViewTitle.setText(data.getTitle());
        holder.textViewTime.setText(data.getTime());
        holder.textViewAddress.setText(data.getAddress());
        holder.textViewPrice.setText(data.getPrice() + "");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ShowHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewTime;
        TextView textViewAddress;
        TextView textViewPrice;

        public ShowHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.iv_show_logo);
            textViewTitle = (TextView) itemView.findViewById(R.id.tv_show_title);
            textViewTime = (TextView) itemView.findViewById(R.id.tv_show_time);
            textViewAddress = (TextView) itemView.findViewById(R.id.tv_show_address);
            textViewPrice = (TextView) itemView.findViewById(R.id.tv_show_price);

        }
    }
}
