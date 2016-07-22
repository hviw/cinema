package com.force.cinemaline.module.first.bean;

/**
 * Created by force on 16-7-17.
 */
public class NewItem {

    private String imageUrl;
    private String newsTitle;
    private String newsContent;

    public NewItem() {
    }

    public NewItem(String imageUrl, String newsTitle, String newsContent) {
        this.imageUrl = imageUrl;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Override
    public String toString() {
        return "NewItem{" +
                "imageUrl='" + imageUrl + '\'' +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                '}';
    }
}
