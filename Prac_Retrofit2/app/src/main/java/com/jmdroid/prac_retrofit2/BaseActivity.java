package com.jmdroid.prac_retrofit2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jmdroid.prac_retrofit2.retrofit.RetrofitGenterator;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 레트로핏 초기 설정
        RetrofitGenterator.getInstance().launch_retrofit(getApplicationContext());
    }
}
