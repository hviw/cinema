package com.force.cinemaline.module.buy.bean;

/**
 * Created by force on 16-7-19.
 */
public class FutureMovieItem {
    int resId;
    String title;
    String actors;
    String content;
    String date;

    public FutureMovieItem(int resId, String title, String actors, String content, String date) {
        this.resId = resId;
        this.title = title;
        this.actors = actors;
        this.content = content;
        this.date = date;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
