package fauzi.hilmy.app21;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class IntentWeb extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar;
    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_LINK = "extra_link";

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_web);

        webView = findViewById(R.id.web);
        progressBar = findViewById(R.id.progresBar);

        String namaWeb = getIntent().getStringExtra(EXTRA_NAME);
        String linkWeb = getIntent().getStringExtra(EXTRA_LINK);

        setActionBarTitle(namaWeb);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(newProgress);
                if (newProgress == 100){
                    progressBar.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        progressBar.setVisibility(View.VISIBLE);
        webView.loadUrl(linkWeb);

    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
