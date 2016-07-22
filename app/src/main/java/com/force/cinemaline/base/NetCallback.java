package com.force.cinemaline.base;

/**
 * Created by force on 16-6-27.
 * 用于网络访问的接口回调,显示网络访问成功或失败信息
 */
public interface NetCallback {
    public void success(String strResult);
    public void fail(String strMsg);
}
