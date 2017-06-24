package com.jcodee.mod3class1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebsiteActivity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);
        ButterKnife.bind(this);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://" + getIntent().getStringExtra("url"));
    }
}
