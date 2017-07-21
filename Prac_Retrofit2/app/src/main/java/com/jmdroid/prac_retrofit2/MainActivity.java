package com.jmdroid.prac_retrofit2;

import android.os.Bundle;
import android.util.Log;

import com.jmdroid.prac_retrofit2.model.InfoModel;
import com.jmdroid.prac_retrofit2.resmodel.ResInfo;
import com.jmdroid.prac_retrofit2.retrofit.RetrofitGenterator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // simple
        callSimpleList();

        // ordinary
        callList();
    }

    // simple
    public void callSimpleList() {
        Call<List<InfoModel>> call = RetrofitGenterator.getInstance().getRetrofitImpFactory().getSimpleList();
        call.enqueue(new Callback<List<InfoModel>>() {
            @Override
            public void onResponse(Call<List<InfoModel>> call, Response<List<InfoModel>> response) {
                Log.i("SIMPLE RES SUC", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<InfoModel>> call, Throwable t) {
                Log.i("SIMPLE RES FAIL", t.toString());
            }
        });
    }

    // ordinary
    public void callList() {
        Call<ResInfo> call = RetrofitGenterator.getInstance().getRetrofitImpFactory().getList();
        call.enqueue(new Callback<ResInfo>() {
            @Override
            public void onResponse(Call<ResInfo> call, Response<ResInfo> response) {
                Log.i("ORDINARY RES SUC", response.body().getMaster());
                Log.i("ORDINARY RES SUC", response.body().getAppList().toString());
                Log.i("ORDINARY RES SUC", response.body().getAppList().get(0).getUrl());
            }

            @Override
            public void onFailure(Call<ResInfo> call, Throwable t) {
                Log.i("ORDINARY RES FAIL", t.toString());
            }
        });
    }

}
