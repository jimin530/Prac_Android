package com.jmdroid.prac_retrofit2.retrofit;


import com.jmdroid.prac_retrofit2.model.InfoModel;
import com.jmdroid.prac_retrofit2.resmodel.ResInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitImpFactory {

    // simple
    @GET("/simple")
    Call<List<InfoModel>> getSimpleList();

    // ordinary
    @GET("/ordinary")
    Call<ResInfo> getList();

}
