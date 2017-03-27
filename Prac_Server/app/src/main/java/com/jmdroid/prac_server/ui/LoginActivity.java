package com.jmdroid.prac_server.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jmdroid.prac_server.MainActivity;
import com.jmdroid.prac_server.R;
import com.jmdroid.prac_server.dto.LoginDTO;
import com.jmdroid.prac_server.network.reqmodel.ReqHeader;
import com.jmdroid.prac_server.network.reqmodel.ReqLogin;
import com.jmdroid.prac_server.network.reqmodel.ReqSignup;
import com.jmdroid.prac_server.network.resmodel.ResBasic;
import com.jmdroid.prac_server.retrofit.RetrofitGenterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText et_login_id;
    EditText et_login_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_login_id = (EditText) findViewById(R.id.et_login_id);
        et_login_password = (EditText) findViewById(R.id.et_login_password);
    }

    public void onLogin(View view) {
        ReqHeader reqHeader = new ReqHeader(
                "Login"
        );
        LoginDTO loginDTO = new LoginDTO(
                et_login_id.getText().toString(),
                et_login_password.getText().toString()
        );
        ReqLogin reqLogin = new ReqLogin(reqHeader, loginDTO);

        callNetLogin(reqLogin);
    }

    public void onClickGoSignup(View view) {
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(intent);
        finish();
    }

    public void callNetLogin(ReqLogin reqLogin) {
        Call<ResBasic> NetLogin = RetrofitGenterator.getInstance().getRetrofitImpFactory().NetLogin(reqLogin);
        NetLogin.enqueue(new Callback<ResBasic>() {
            @Override
            public void onResponse(Call<ResBasic> call, Response<ResBasic> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null && response.body().getMsg() != null) {
                        // 통신 성공
                        Log.i("RES SUC", response.body().getMsg());
                    } else {
                        // 결과값 없음
                        Log.i("RES NULL", response.message().toString());
                    }
                } else {
                    // 결과값 실패
                    Log.i("RES ERR", response.message().toString());
                }
            }

            @Override
            public void onFailure(Call<ResBasic> call, Throwable t) {
                // 통신 실패
                Log.i("RES FAIL", t.getMessage().toString());
            }
        });
    }
}
