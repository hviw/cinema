package com.force.cinemaline.module.find.bean;

import java.util.List;

/**
 * Created by force on 16-7-21.
 */
public class News {

    /**
     * result : 00
     * newsList : [{"id":"16158","title":"2016%E5%B9%B4%E4%B8%8A%E5%8D%8A%E5%B9%B4%E4%B8%AD%E5%9B%BD%E7%A5%A8%E6%88%BF%E6%9C%80%E4%BD%B3Top10","summary":"%E5%85%B6%E4%B8%AD%E5%87%A0%E9%83%A8%E5%B0%B1%E7%9C%9F%E7%9A%84%E9%A2%87%E8%AE%A9%E4%BA%BA%E6%84%8F%E5%A4%96%E7%9A%84%E5%95%8A%21","imgUrl":"http://image.189mv.cn/images/files/FilmNews/news_43860.jpg"},{"id":"16138","title":"2016%E5%B9%B47%E6%9C%88%E5%86%85%E5%9C%B0%E5%BD%B1%E5%B8%82%E5%89%8D%E7%9E%BB","summary":"%E5%9B%BD%E4%BA%A7%E7%89%87%E8%BF%8E%E6%9D%A5%E7%8B%82%E6%AC%A2%E5%AD%A3+%E8%BF%9B%E5%8F%A3%E7%89%87%E6%89%93%E5%93%8D%E4%BC%8F%E5%87%BB%E6%88%98","imgUrl":"http://image.189mv.cn/images/files/FilmNews/news_43740.jpg"},{"id":"16119","title":"2016%E5%B9%B46%E6%9C%88%E5%86%85%E5%9C%B0%E5%BD%B1%E5%B8%82%E5%89%8D%E7%9E%BB","summary":"%E3%80%8A%E9%AD%94%E5%85%BD%E3%80%8B%E5%BC%95%E9%A2%86%E5%85%A8%E6%B0%91%E9%A3%8E%E6%BD%AE+%E3%80%8A%E7%8B%AC%E7%AB%8B%E6%97%A52%E3%80%8B%E5%86%8D%E6%88%98%E5%A4%96%E6%98%9F%E5%A4%A7%E5%86%9B","imgUrl":"http://image.189mv.cn/images/files/FilmNews/news_43744.jpg"},{"id":"16098","title":"%E3%80%8A%E6%B5%B7%E5%BA%95%E6%80%BB%E5%8A%A8%E5%91%982%E3%80%8B%E6%9B%9D%E5%85%89%E5%85%A8%E6%96%B0%E9%A2%84%E5%91%8A","summary":"%E5%A4%9A%E8%8E%89%E8%BA%AB%E9%99%B7%E6%B5%B7%E6%B4%8B%E5%85%AC%E5%9B%AD+%E6%9B%B4%E5%A4%9A%E6%96%B0%E8%A7%92%E8%89%B2%E4%BA%AE%E7%9B%B8","imgUrl":"http://image.189mv.cn/images/files/FilmNews/news_43382.jpg"},{"id":"16079","title":"%E3%80%8A%E9%AD%94%E5%85%BD%E3%80%8B%E4%B8%AD%E5%9B%BD%E5%86%85%E5%9C%B0%E5%AE%9A%E6%A1%A36.8","summary":"%E4%B8%8E%E3%80%8AX%E6%88%98%E8%AD%A6%E5%A4%A9%E5%90%AF%E3%80%8B%E7%9B%B8%E9%81%87+6%E6%9C%88%E5%BD%B1%E5%B8%82%E7%87%83%E7%88%86","imgUrl":"http://image.189mv.cn/images/files/FilmNews/news_43259.jpg"},{"id":"16063","title":"%E3%80%8A%E8%B6%85%E8%84%91%E3%80%8B%E6%9B%9D%E9%A2%84%E5%91%8A","summary":"%E9%99%90%E6%97%B6%E5%A4%BA%E5%91%BD%E8%B0%8D%E6%88%98%E6%B8%90%E9%9C%B2%E7%9C%9F%E5%AE%B9%E3%80%82","imgUrl":"http://image.189mv.cn/images/files/FilmNews/news_43206.jpg"},{"id":"16061","title":"%E2%80%9C%E6%AD%BB%E4%BE%8D%E2%80%9D%E6%96%B0%E7%89%87%E3%80%8A%E5%B9%BB%E4%BD%93%E3%80%8B","summary":"%E5%86%85%E5%9C%B0%E5%AE%9A%E6%A1%A35.12","imgUrl":"http://image.189mv.cn/images/files/FilmNews/news_43203.jpg"},{"id":"16059","title":"%E3%80%8A%E6%A2%A6%E6%83%B3%E5%90%88%E4%BC%99%E4%BA%BA%E3%80%8B%E7%BB%88%E6%9E%81%E9%A2%84%E5%91%8A%E6%B5%B7%E6%8A%A5%E5%8F%8C%E5%8F%91","summary":"%E6%9D%8E%E6%99%A8%E6%84%9F%E5%8F%B9%E5%A7%9A%E6%99%A8%E7%9A%84%E6%A2%A6%E6%83%B3%E2%80%9C%E5%A4%AA%E5%88%BA%E6%BF%80","imgUrl":"http://image.189mv.cn/images/files/FilmNews/news_43200.jpeg"},{"id":"16039","title":"%E3%80%8A%E6%A2%A6%E6%83%B3%E5%90%88%E4%BC%99%E4%BA%BA%E3%80%8B%E6%9B%9D%E5%8D%B1%E6%9C%BA%E7%89%88%E9%A2%84%E5%91%8A","summary":"%E4%B8%89%E5%A7%90%E5%A6%B9%E5%85%B3%E7%B3%BB%E7%A0%B4%E8%A3%82","imgUrl":"http://image.189mv.cn/images/files/FilmNews/news_43140.jpg"},{"id":"16021","title":"%E5%90%B4%E7%A7%80%E6%B3%A2%E6%B1%A4%E5%94%AF%E6%B7%B1%E6%83%85%E6%8B%A5%E6%8A%B1%E4%BA%B2%E5%90%BB%E9%A2%9D%E5%A4%B4%E5%86%8D%E7%BB%AD%E5%89%8D%E7%BC%98","summary":"%E3%80%8A%E5%8C%97%E4%BA%AC%E9%81%87%E4%B8%8A%E8%A5%BF%E9%9B%85%E5%9B%BE2%E4%B8%8D%E4%BA%8C%E6%83%85%E4%B9%A6%E3%80%8B%E5%B0%86%E4%BA%8E4%E6%9C%8829%E6%97%A5%E4%B8%8A%E6%98%A0","imgUrl":"http://image.189mv.cn/images/files/FilmNews/news_43127.jpg"}]
     */

    private String result;
    /**
     * id : 16158
     * title : 2016%E5%B9%B4%E4%B8%8A%E5%8D%8A%E5%B9%B4%E4%B8%AD%E5%9B%BD%E7%A5%A8%E6%88%BF%E6%9C%80%E4%BD%B3Top10
     * summary : %E5%85%B6%E4%B8%AD%E5%87%A0%E9%83%A8%E5%B0%B1%E7%9C%9F%E7%9A%84%E9%A2%87%E8%AE%A9%E4%BA%BA%E6%84%8F%E5%A4%96%E7%9A%84%E5%95%8A%21
     * imgUrl : http://image.189mv.cn/images/files/FilmNews/news_43860.jpg
     */

    private List<NewsListBean> newsList;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<NewsListBean> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsListBean> newsList) {
        this.newsList = newsList;
    }

    public static class NewsListBean {
        private String id;
        private String title;
        private String summary;
        private String imgUrl;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
