package com.jmdroid.prac_server.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jmdroid.prac_server.R;
import com.jmdroid.prac_server.accout.AccountMange;
import com.jmdroid.prac_server.dto.ChangePasswordDTO;
import com.jmdroid.prac_server.network.reqmodel.ReqChangePassword;
import com.jmdroid.prac_server.network.reqmodel.ReqHeader;
import com.jmdroid.prac_server.network.resmodel.ResBasic;
import com.jmdroid.prac_server.retrofit.RetrofitGenterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText et_beforepassword;
    EditText et_newpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        et_beforepassword = (EditText) findViewById(R.id.et_beforepassword);
        et_newpassword = (EditText) findViewById(R.id.et_newpassword);
    }

    public void onChangePassword(View view) {
        ReqHeader reqHeader = new ReqHeader(
                "ChagePassword"
        );
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO(
                AccountMange.getInstance().user_id,
                et_beforepassword.getText().toString(),
                et_newpassword.getText().toString()
        );
        ReqChangePassword reqChangePassword = new ReqChangePassword(reqHeader, changePasswordDTO);

        callNetChangePassword(reqChangePassword);
    }

    public void callNetChangePassword(ReqChangePassword reqChangePassword) {
        Call<ResBasic> NetChangePassword = RetrofitGenterator.getInstance().getRetrofitImpFactory().NetChangePassword(reqChangePassword);
        NetChangePassword.enqueue(new Callback<ResBasic>() {
            @Override
            public void onResponse(Call<ResBasic> call, Response<ResBasic> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null && response.body().getMsg() != null) {
                        // 통신 성공
                        Log.i("RES SUC", response.body().getMsg());
                        if (response.body().getMsg().contains("성공")) {
                            Toast.makeText(ChangePasswordActivity.this, "비밀번호 변경 완료", Toast.LENGTH_SHORT).show();
                            finish();
                        }
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
