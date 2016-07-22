package com.force.cinemaline.module.cinema.bean;

/**
 * Created by force on 16-7-19.
 */
public class CinemaItem {

    private String name;
    private String price;
    private String address;

    public CinemaItem(String name, String price, String address) {
        this.name = name;
        this.price = price;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
