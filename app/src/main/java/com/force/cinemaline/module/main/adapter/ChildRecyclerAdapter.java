package com.force.cinemaline.module.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.common.constant.Constant;

import java.util.List;

/**
 * Created by force on 16-7-20.
 */
public class ChildRecyclerAdapter extends RecyclerView.Adapter<ChildRecyclerAdapter.CityHolder> {
    Context mContext;
    List<String> list;

    public ChildRecyclerAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override
    public CityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_city_child_self,
                parent, false);

        return new CityHolder(view);
    }

    @Override
    public void onBindViewHolder(CityHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class CityHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public CityHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_city_child);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.tv_city_child:
                            String s = textView.getText().toString();
                            Intent intent = new Intent(Constant.APP_KEY);
                            intent.putExtra("location", s);

                            LocalBroadcastManager manager = LocalBroadcastManager.getInstance(mContext);
                            manager.sendBroadcast(intent);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
    }
}
