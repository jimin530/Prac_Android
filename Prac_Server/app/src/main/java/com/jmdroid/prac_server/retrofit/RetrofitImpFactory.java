package com.jmdroid.prac_server.retrofit;


import com.jmdroid.prac_server.network.reqmodel.ReqChangePassword;
import com.jmdroid.prac_server.network.reqmodel.ReqLogin;
import com.jmdroid.prac_server.network.reqmodel.ReqSignup;
import com.jmdroid.prac_server.network.resmodel.ResBasic;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitImpFactory {

    // 회원가입
    @POST("/jm_signup")
    Call<ResBasic> NetSignup(@Body ReqSignup reqSignup);

    // 로그인
    @POST("/jm_login")
    Call<ResBasic> NetLogin(@Body ReqLogin reqLogin);

    // 회원 조회
    @GET("/jm_memberinfo")
    Call<ResBasic> NetMemberInfo();

    // 비밀번호 변경
    @POST("/jm_changepassword")
    Call<ResBasic> NetChangePassword(@Body ReqChangePassword reqChangePassword);
}
