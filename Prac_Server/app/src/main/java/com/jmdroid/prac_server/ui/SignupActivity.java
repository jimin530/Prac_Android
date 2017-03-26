package com.jmdroid.prac_server.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.jmdroid.prac_server.R;
import com.jmdroid.prac_server.dto.SignupDTO;
import com.jmdroid.prac_server.network.reqmodel.ReqHeader;
import com.jmdroid.prac_server.network.reqmodel.ReqSignup;
import com.jmdroid.prac_server.network.resmodel.ResBasic;
import com.jmdroid.prac_server.retrofit.RetrofitGenterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    EditText et_signup_id;
    EditText et_signup_password;
    EditText et_signup_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et_signup_id = (EditText) findViewById(R.id.et_signup_id);
        et_signup_name = (EditText) findViewById(R.id.et_signup_name);
        et_signup_password = (EditText) findViewById(R.id.et_signup_password);
    }

    public void onClickSignup(View view) {
        ReqHeader reqHeader = new ReqHeader(
                "Signup"
        );
        SignupDTO signupDTO = new SignupDTO(
                et_signup_id.getText().toString(),
                et_signup_password.getText().toString(),
                et_signup_name.getText().toString()
        );
        ReqSignup reqSignup = new ReqSignup(reqHeader, signupDTO);

        callNetSignup(reqSignup);
    }

    public void callNetSignup(ReqSignup reqSignup) {
        Call<ResBasic> NetSignup = RetrofitGenterator.getInstance().getRetrofitImpFactory().NetSignup(reqSignup);
        NetSignup.enqueue(new Callback<ResBasic>() {
            @Override
            public void onResponse(Call<ResBasic> call, Response<ResBasic> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null && response.body().getMsg() != null) {
                        Log.i("RES SUC", response.body().getMsg());
                    } else {
                        Log.i("RES NULL", response.message().toString());
                    }
                } else {
                    Log.i("RES ERR", response.message().toString());
                }
            }

            @Override
            public void onFailure(Call<ResBasic> call, Throwable t) {
                Log.i("RES FAIL", t.getMessage().toString());
            }
        });
    }
}
