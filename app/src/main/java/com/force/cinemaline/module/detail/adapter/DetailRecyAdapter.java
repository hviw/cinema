package com.force.cinemaline.module.detail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.force.cinemaline.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by force on 16-7-22.
 */
public class DetailRecyAdapter extends RecyclerView.Adapter<DetailRecyAdapter.PicHolder> {

    private Context mContext;
    private List<String> mPicList;

    public DetailRecyAdapter(Context context, List<String> mPicList) {
        this.mContext = context;
        this.mPicList = mPicList;
    }

    @Override
    public PicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_detail_pic,
                parent, false);
        return new PicHolder(view);
    }

    @Override
    public void onBindViewHolder(PicHolder holder, int position) {
        String picUrl = mPicList.get(position);
        Picasso.with(mContext).load(picUrl).resize(160, 90).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mPicList.size();
    }

    public class PicHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public PicHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_detail_pic_item);
        }
    }
}
