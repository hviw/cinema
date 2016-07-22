package com.force.cinemaline.module.find.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.force.cinemaline.R;

/**
 * Created by Administrator on 2016/7/16.
 */
public class MyExpandableListAdapter implements ExpandableListAdapter {
     private  Context mcontext;

    public MyExpandableListAdapter(Context context){
        mcontext=context;
    }

    int[] logos = new int[]{
            R.mipmap.main_arrow_down,
            R.mipmap.main_arrow_down,
            R.mipmap.main_arrow_down,
            R.mipmap.main_arrow_down,
    };
    private String[] armTypes = new String[]{
            "罗湖区", "福田区", "南山区", "宝安区","龙岗区","龙华新区"
    };
    private String[][] arms = new String[][]{
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"},
    };

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return armTypes.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return arms[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return armTypes[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return arms[groupPosition][childPosition];
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
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LinearLayout ll = new LinearLayout(mcontext);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ImageView logo = new ImageView(mcontext);
        logo.setImageResource(logos[groupPosition]);
        logo.setPadding(36, 15, 0, 0);
        ll.addView(logo);
        TextView textView = getTextView();
        textView.setText(getGroup(groupPosition).toString());
        textView.setPadding(10, 0, 0, 0);
        ll.addView(textView);
        return ll;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView textView = getTextView();
        textView.setText(getChild(groupPosition, childPosition).toString());
        return textView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }

    private TextView getTextView() {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 64);
        TextView textView = new TextView(mcontext);
        textView.setLayoutParams(lp);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        textView.setPadding(36, 0, 0, 0);
        textView.setTextSize(20);
        return textView;
    }
}