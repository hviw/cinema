package com.force.cinemaline.module.first.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.module.first.bean.TodayMovieItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FirstRecyclerAdapter extends RecyclerView.Adapter<FirstRecyclerAdapter.MyHolder> {

    Context context;
    List<TodayMovieItem.ResultBean> resultBeanList;

    public FirstRecyclerAdapter(Context context, List<TodayMovieItem.ResultBean> resultBeanList) {
        this.context = context;
        this.resultBeanList = resultBeanList;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_first_page_movie,
                parent, false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        TodayMovieItem.ResultBean resultBean = resultBeanList.get(position);


        String pic_url = resultBean.getPic_url();
        Picasso.with(context).load(pic_url).into(holder.imageViewLogo);

        holder.textViewName.setText(resultBean.getMovieName());
        holder.ratingBarRate.setRating(5.0f);
        holder.textViewRate.setText(5.0 + "");
    }

    @Override
    public int getItemCount() {
        return resultBeanList == null ? 0 : resultBeanList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageViewLogo;
        TextView textViewName;
        RatingBar ratingBarRate;
        TextView textViewRate;
        public MyHolder(View itemView) {
            super(itemView);
            imageViewLogo = (ImageView) itemView.findViewById(R.id.iv_item_first_movie_image);
            textViewName = (TextView) itemView.findViewById(R.id.tv_item_first_movie_name);
            ratingBarRate = (RatingBar) itemView.findViewById(R.id.rb_item_first_movie_rate);
            textViewRate = (TextView) itemView.findViewById(R.id.tv_first_rate);
        }
    }
}
