package com.force.cinemaline.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getViewId(), container, false);

        findViews(view);
        init();
        initEvent();
        loadData();

        return view;
    }

    protected abstract int getViewId();

    protected abstract void findViews(View view);

    protected abstract void init();

    protected abstract void initEvent();

    protected abstract void loadData();
}
