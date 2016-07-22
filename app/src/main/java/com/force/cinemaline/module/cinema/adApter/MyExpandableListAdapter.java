package com.force.cinemaline.module.cinema.adApter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.force.cinemaline.R;
import com.force.cinemaline.module.cinema.bean.CinemaItem;

import java.util.List;

/**
 * Created by Administrator on 2016/7/16.
 */
public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    private  Context mContext;

    private List<String> listGroup;
    private List<List<CinemaItem>> listChildren;

    public  MyExpandableListAdapter( Context context, List<String> listGroup,
                                     List<List<CinemaItem>> listChildren){
        this.mContext = context;
        this.listGroup = listGroup;
        this.listChildren = listChildren;
    }

    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        int size = listChildren.get(groupPosition).size();
        return size;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listChildren.get(groupPosition).get(childPosition);
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
        TextView textView = (TextView) convertView.findViewById(R.id.tv_cinema_group_title);
        textView.setText(listGroup.get(groupPosition));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        CinemaHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_cinema_child,
                    parent, false);

            holder = new CinemaHolder();
            holder.textViewName = (TextView) convertView.findViewById(R.id.tv_cinema_child_name);
            holder.textViewAddress = (TextView) convertView.findViewById(R.id.tv_cinema_child_address);
            holder.textViewPrice = (TextView) convertView.findViewById(R.id.tv_cinema_child_price);

            convertView.setTag(holder);
        } else {
            holder = (CinemaHolder) convertView.getTag();
        }

        CinemaItem cinemaItem = listChildren.get(groupPosition).get(childPosition);

        holder.textViewName.setText(cinemaItem.getName());
        holder.textViewPrice.setText(cinemaItem.getPrice());
        holder.textViewAddress.setText(cinemaItem.getAddress());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    class CinemaHolder{
        TextView textViewName;
        TextView textViewPrice;
        TextView textViewAddress;
    }
}