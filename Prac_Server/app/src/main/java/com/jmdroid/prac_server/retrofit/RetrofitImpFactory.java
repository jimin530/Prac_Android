package com.jmdroid.prac_server.retrofit;


import com.jmdroid.prac_server.dto.SignupDTO;
import com.jmdroid.prac_server.network.resmodel.ResBasic;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitImpFactory {

    // 회원가입
    @POST("/jm_signup")
    Call<ResBasic> NetSignup(@Body SignupDTO signupDTO);

}
