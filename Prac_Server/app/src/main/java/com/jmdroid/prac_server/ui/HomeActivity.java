package com.jmdroid.prac_server.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.jmdroid.prac_server.R;
import com.jmdroid.prac_server.network.resmodel.ResMemberInfo;
import com.jmdroid.prac_server.retrofit.RetrofitGenterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onMemberInfo(View view) {
        callNetMemberInfo();
    }

    public void onGoChangePassword(View view) {
        Intent intent = new Intent(HomeActivity.this, ChangePasswordActivity.class);
        startActivity(intent);
    }

    public void callNetMemberInfo() {
        Call<ResMemberInfo> NetMemberInfo = RetrofitGenterator.getInstance().getRetrofitImpFactory().NetMemberInfo();
        NetMemberInfo.enqueue(new Callback<ResMemberInfo>() {
            @Override
            public void onResponse(Call<ResMemberInfo> call, Response<ResMemberInfo> response) {

                if (response.isSuccessful()) {
                    /*if (response.body() != null && response.body().toString() != null) {

                    } else {
                        Log.i("RESPONSE RESULT 1: ", response.message());
                    }*/
                    Log.i("RESPONSE 확인 : ", response.body().getBody().toString());
                } else {
                    // 결과값 실패
                    Log.i("RES ERR", response.message().toString());
                }
            }

            @Override
            public void onFailure(Call<ResMemberInfo> call, Throwable t) {
                // 통신 실패
                Log.i("RES FAIL", t.getMessage().toString());
            }
        });
    }
}
