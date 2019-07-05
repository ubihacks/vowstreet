package com.ubihacks.vowstreet.vowstreet;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wang.avi.AVLoadingIndicatorView;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    private AVLoadingIndicatorView LoadingWeb;
    public static final String USER_AGENT = "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        WebSettings webSettings = webView.getSettings();
        webView.setBackgroundColor(Color.TRANSPARENT);
        webSettings.setJavaScriptEnabled(true);

        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportMultipleWindows(true);
        webSettings.setUserAgentString(USER_AGENT);
        webSettings.setDomStorageEnabled(true);

        //webView.setWebViewClient(new MyCustomWebViewClient());
        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        //webView.setWebChromeClient(new MyCustomChromeClient());


        webView.loadUrl("https://vowstreet.com/");

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);


                LoadingWeb.setVisibility(View.VISIBLE);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);


                LoadingWeb.setVisibility(View.GONE);

            }


        });






    }

    @Override
    public void onBackPressed() {

        if (webView.canGoBack()) {

            webView.goBack();
        } else {
            super.onBackPressed();

        }
    }

    private void initView() {
        webView = (WebView) findViewById(R.id.webview);

        LoadingWeb = (AVLoadingIndicatorView) findViewById(R.id.loadingWeb);
    }
}
