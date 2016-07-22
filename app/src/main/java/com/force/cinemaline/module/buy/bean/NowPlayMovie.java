package com.force.cinemaline.module.buy.bean;

/**
 * Created by force on 16-7-19.
 */
public class NowPlayMovie {
    int resId;
    String title;
    String actors;
    String instruction;
    String rate;

    public NowPlayMovie(int resId, String title, String actors, String instruction, String rate) {
        this.resId = resId;
        this.title = title;
        this.actors = actors;
        this.instruction = instruction;
        this.rate = rate;
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

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
