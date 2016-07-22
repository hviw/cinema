package com.force.cinemaline.module.buy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.module.buy.bean.NowPlayMovie;
import com.force.cinemaline.module.detail.ui.DetailActivity;
import com.force.cinemaline.module.first.bean.TodayMovieItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by force on 16-7-19.
 */
public class NowPlayRecyclerAdapter extends RecyclerView.Adapter<NowPlayRecyclerAdapter.MyHolder> {

//    List<TodayMovieItem.ResultBean> list;
    List<NowPlayMovie> list;
    Context context;

    public NowPlayRecyclerAdapter(Context context, List<NowPlayMovie> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_buy_movie_now, parent, false);
        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
//        TodayMovieItem.ResultBean resultBean = list.get(position);
        NowPlayMovie movie = list.get(position);
        holder.imageView.setImageResource(movie.getResId());
        holder.textViewTitle.setText(movie.getTitle());
        holder.textViewActors.setText(movie.getActors());
        holder.textViewInstruction.setText(movie.getInstruction());
        holder.textViewRate.setText(movie.getRate());
//        String pic_url = resultBean.getPic_url();

//        Picasso.with(context).load(pic_url).into(holder.imageView);

//        holder.textViewTitle.setText(resultBean.getMovieName());
//        holder.textViewInstruction.setText(resultBean.getMovieId());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewActors;
        TextView textViewInstruction;
        TextView textViewBuy;
        TextView textViewRate;

        public MyHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.iv_movie_now_logo);
            textViewTitle = (TextView) itemView.findViewById(R.id.tv_movie_now_title);
            textViewActors = (TextView) itemView.findViewById(R.id.tv_movie_now_actors);
            textViewInstruction = (TextView) itemView.findViewById(R.id.tv_movie_now_introduction);
            textViewBuy = (TextView) itemView.findViewById(R.id.tv_movie_now_buy);
            textViewRate = (TextView) itemView.findViewById(R.id.tv_movie_now_rate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, DetailActivity.class));
                }
            });
        }
    }
}
