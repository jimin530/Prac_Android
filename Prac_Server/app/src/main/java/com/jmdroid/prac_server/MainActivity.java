package com.jmdroid.prac_server;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jmdroid.prac_server.accout.AccountMange;
import com.jmdroid.prac_server.retrofit.RetrofitGenterator;
import com.jmdroid.prac_server.ui.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 레트로핏 초기 설정
        RetrofitGenterator.getInstance().launch_retrofit(getApplicationContext());

        // 로그인 아이디 초기 null
        AccountMange.getInstance().user_id = "";

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
