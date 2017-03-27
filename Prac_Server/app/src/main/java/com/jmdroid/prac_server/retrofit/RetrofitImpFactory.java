package com.jmdroid.prac_server.retrofit;


import com.jmdroid.prac_server.network.reqmodel.ReqLogin;
import com.jmdroid.prac_server.network.reqmodel.ReqSignup;
import com.jmdroid.prac_server.network.resmodel.ResBasic;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitImpFactory {

    // 회원가입
    @POST("/jm_signup")
    Call<ResBasic> NetSignup(@Body ReqSignup reqSignup);

    @POST("/jm_login")
    Call<ResBasic> NetLogin(@Body ReqLogin reqLogin);

}
