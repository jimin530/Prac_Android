package com.jmdroid.prac_server.accout;

import android.content.Context;

import com.jmdroid.prac_server.retrofit.RetrofitImpFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tacademy on 2017-02-20.
 */
public class AccountMange {
    private static AccountMange ourInstance = new AccountMange();
    public static AccountMange getInstance() {
        return ourInstance;
    }
    private AccountMange() {
    }

    public String user_id;
}

















