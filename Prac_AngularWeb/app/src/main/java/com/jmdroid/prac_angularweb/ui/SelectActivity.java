package com.jmdroid.prac_angularweb.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jmdroid.prac_angularweb.R;
import com.jmdroid.prac_angularweb.storage.SPHelper;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        SPHelper.getInstance().setString(SelectActivity.this, "url", "http://219.248.137.8:8888/jimin/Angular_Notice/");

        Intent intent = new Intent(SelectActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void on1(View view) {
        SPHelper.getInstance().setString(SelectActivity.this, "url", "http://219.248.137.8:8888/jimin/Prac_Angular/");

        Intent intent = new Intent(SelectActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void on2(View view) {
        SPHelper.getInstance().setString(SelectActivity.this, "url", "http://219.248.137.8:8888/jimin/BoxOffice/");

        Intent intent = new Intent(SelectActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
