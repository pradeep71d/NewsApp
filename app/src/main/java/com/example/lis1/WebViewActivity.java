package com.example.lis1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Bundle bundle =getIntent().getExtras();
       s= bundle.getString("key");
        Log.d("TAG","hello:"+s);
        WebView webView=findViewById(R.id.web);
        // loading http://www.google.com url in the the WebView.
        webView.loadUrl(s);
        // this will enable the javascipt.
        webView.getSettings().setJavaScriptEnabled(true);
        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        webView.setWebViewClient(new WebViewClient());
    }
}
