package com.jmdroid.prac_retrofit2.model;

/**
 * Created by jimin on 2017. 9. 21..
 */

public class SampleModel {
    int baseDate;
    int baseTime;
    String category;
    int nx;
    int ny;
    int obsrValue;

    public SampleModel() {
    }

    @Override
    public String toString() {
        return "SampleModel{" +
                "baseDate=" + baseDate +
                ", baseTime=" + baseTime +
                ", category='" + category + '\'' +
                ", nx=" + nx +
                ", ny=" + ny +
                ", obsrValue=" + obsrValue +
                '}';
    }

    public int getBaseDate() {
        return baseDate;
    }

    public void setBaseDate(int baseDate) {
        this.baseDate = baseDate;
    }

    public int getBaseTime() {
        return baseTime;
    }

    public void setBaseTime(int baseTime) {
        this.baseTime = baseTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNx() {
        return nx;
    }

    public void setNx(int nx) {
        this.nx = nx;
    }

    public int getNy() {
        return ny;
    }

    public void setNy(int ny) {
        this.ny = ny;
    }

    public int getObsrValue() {
        return obsrValue;
    }

    public void setObsrValue(int obsrValue) {
        this.obsrValue = obsrValue;
    }

    public SampleModel(int baseDate, int baseTime, String category, int nx, int ny, int obsrValue) {

        this.baseDate = baseDate;
        this.baseTime = baseTime;
        this.category = category;
        this.nx = nx;
        this.ny = ny;
        this.obsrValue = obsrValue;
    }
}
