package com.force.cinemaline.module.main.bean;

import java.util.List;

/**
 * Created by force on 16-7-19.
 */
public class City {

    /**
     * n : 直辖市
     * c : ["北京","上海","天津","重庆"]
     */

    private List<ChinaBean> China;

    public List<ChinaBean> getChina() {
        return China;
    }

    public void setChina(List<ChinaBean> China) {
        this.China = China;
    }

    public static class ChinaBean {
        private String n;
        private List<String> c;

        public String getN() {
            return n;
        }

        public void setN(String n) {
            this.n = n;
        }

        public List<String> getC() {
            return c;
        }

        public void setC(List<String> c) {
            this.c = c;
        }
    }
}
