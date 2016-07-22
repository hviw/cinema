package com.force.cinemaline.module.buy.bean;

/**
 * Created by force on 16-7-19.
 */
public class ShowData {

    int resId;
    String title;
    String time;
    String address;
    int price;

    public ShowData(int resId, String title, String time, String address, int price) {
        this.resId = resId;
        this.title = title;
        this.time = time;
        this.address = address;
        this.price = price;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
