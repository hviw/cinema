package com.force.cinemaline.module.main.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.module.main.bean.City;

import java.util.List;

/**
 * Created by force on 16-7-20.
 */
public class CityExpandableAdapter extends BaseExpandableListAdapter {

    Context mContext;

    List<City.ChinaBean> list;
    public CityExpandableAdapter(Context context, List<City.ChinaBean> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override
    public int getGroupCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition).getN();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getC().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_cinema_group,
                    parent, false);
        }
        TextView tvGroup = (TextView) convertView.findViewById(R.id.tv_cinema_group_title);
        tvGroup.setText(list.get(groupPosition).getN());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_city_child,
                    parent, false);
        }

        RecyclerView recyclerView = (RecyclerView) convertView.findViewById(R.id.rv_city_child_container);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
        ChildRecyclerAdapter adapter = new ChildRecyclerAdapter(mContext, list.get(groupPosition).getC());
        recyclerView.setAdapter(adapter);

        return convertView;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
