package com.jmdroid.prac_retrofit2.model;

/**
 * Created by jimin on 2017. 7. 21..
 */

public class InfoModel {
    String rank;
    String Nm;
    String url;

    public InfoModel() {
    }

    public InfoModel(String rank, String nm, String url) {

        this.rank = rank;
        Nm = nm;
        this.url = url;
    }

    public String getRank() {

        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getNm() {
        return Nm;
    }

    public void setNm(String nm) {
        Nm = nm;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "InfoModel{" +
                "rank='" + rank + '\'' +
                ", Nm='" + Nm + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
