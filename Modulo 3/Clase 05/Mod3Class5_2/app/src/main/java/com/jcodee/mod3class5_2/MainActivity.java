package com.jcodee.mod3class5_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jcodee.mod3class5_2.service.InternetService;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnStart)
    public void onBtnStartClicked() {
        intent = new Intent(MainActivity.this, InternetService.class);
        startService(intent);
    }

    @OnClick(R.id.btnStop)
    public void onBtnStopClicked() {
        stopService(intent);
    }
}
