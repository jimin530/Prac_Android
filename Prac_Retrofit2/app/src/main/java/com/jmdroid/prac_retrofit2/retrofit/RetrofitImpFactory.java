package com.jmdroid.prac_retrofit2.retrofit;


import com.jmdroid.prac_retrofit2.model.InfoModel;
import com.jmdroid.prac_retrofit2.resmodel.ResInfo;
import com.jmdroid.prac_retrofit2.resmodel.ResSample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitImpFactory {

    // simple
    @GET("/simple")
    Call<List<InfoModel>> getSimpleList();

    // ordinary
    @GET("/ordinary")
    Call<ResInfo> getList();

    @GET("/service/SecndSrtpdFrcstInfoService2/ForecastGrib")
    Call<ResSample> loadAnswer(@Query("ServiceKey") String ServiceKey, @Query("nx") String nx, @Query("ny") String ny, @Query("base_date") String base_date, @Query("base_time") String base_time, @Query ("type") String type);

}
