package com.force.cinemaline.module.find.ui;

import android.view.View;
import android.widget.ExpandableListView;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseFragment;
import com.force.cinemaline.module.cinema.adApter.MyExpandableListAdapter;

/**
 * Created by Administrator on 2016/7/13.
 * 国际
 */
public class YxuanFragment extends BaseFragment {
    private ExpandableListView yxuan_mexpablsv;

    @Override
    protected int getViewId() {
        return R.layout.fragment_yxuan;
    }

    @Override
    protected void findViews(View view) {
        yxuan_mexpablsv = (ExpandableListView) view.findViewById(R.id.find_yxuan_explsv);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initEvent() {
//        MyExpandableListAdapter adapter = new MyExpandableListAdapter(getContext());
//        yxuan_mexpablsv.setAdapter(adapter);
//        yxuan_mexpablsv.setGroupIndicator(null);
    }

    @Override
    protected void loadData() {

    }
}
