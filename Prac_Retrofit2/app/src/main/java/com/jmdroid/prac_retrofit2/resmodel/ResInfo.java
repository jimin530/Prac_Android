package com.jmdroid.prac_retrofit2.resmodel;

import com.jmdroid.prac_retrofit2.model.InfoModel;

import java.util.List;

/**
 * Created by jimin on 2017. 7. 21..
 */

public class ResInfo {
    private String master;
    private List<InfoModel> appList;

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public List<InfoModel> getAppList() {
        return appList;
    }

    public void setAppList(List<InfoModel> appList) {
        this.appList = appList;
    }
}