package com.guercifzone.wl_ninja;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ProxyInfo;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;

public class Home extends AppCompatActivity {
WebView mywebview;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mywebview = (WebView) findViewById(R.id.webview);
        /* download webpage
        String htmlContent = WebPageDownloader.downloadWebPage("https://www.example.com");
       FileUtils.saveToFile(htmlContent, this);
        Context context = null;
        File offlineFile = new File(context.getFilesDir(), "offlinePage.html");
        mywebview.loadUrl("file://" + offlineFile.getAbsolutePath());*/
        /*  Use an HTTP Proxy


        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);

// Set proxy for WebView
        ProxyInfo proxyInfo = ProxyInfo.buildDirectProxy("proxyserver.com", 8080);
        mywebview.setWebViewClient(new WebViewClient());*/
        /*Disable Tracking and Cookies
        WebSettings webSettings = webView.getSettings();
webSettings.setJavaScriptEnabled(true);
webSettings.setAllowFileAccess(false);
webSettings.setAllowContentAccess(false);

// Disable cookies
CookieManager cookieManager = CookieManager.getInstance();
cookieManager.setAcceptThirdPartyCookies(webView, false);
cookieManager.removeAllCookies(null);

// Block tracking scripts (simple example)
webView.setWebViewClient(new WebViewClient() {
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        if (url.contains("trackersite.com")) {
            view.stopLoading(); // Block known tracking sites
        }
    }
});
        * */
        /*  Use Tor for Android (Orbot)
        // Set WebView's settings
WebView webView = findViewById(R.id.webview);
WebSettings webSettings = webView.getSettings();
webSettings.setJavaScriptEnabled(true);

// Set proxy for Tor (using Orbot as a proxy)
ProxyInfo proxyInfo = ProxyInfo.buildDirectProxy("127.0.0.1", 8118); // Default Tor SOCKS5 Proxy
webView.setWebViewClient(new WebViewClient());
webView.loadUrl("https://check.torproject.org"); // This will confirm if you are using Tor

        */
        /* Ensure HTTPS Connections
        WebView webView = findViewById(R.id.webview);
webView.getSettings().setJavaScriptEnabled(true);

// Enforce HTTPS loading only
webView.setWebViewClient(new WebViewClient() {
    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        if (!request.getUrl().toString().startsWith("https://")) {
            view.loadUrl("https://fallbacksecurepage.com");
        }
    }
});

         */
        /*Enable Private Browsing Mode
// Clear cache and cookies
WebView webView = findViewById(R.id.webview);
webView.getSettings().setJavaScriptEnabled(true);
webView.clearCache(true);
webView.clearHistory();

// Set WebView client
webView.setWebViewClient(new WebViewClient());
webView.loadUrl("https://example.com");

* */
        /* Disable JavaScript for Blocking Ads
        WebView webView = findViewById(R.id.webView);
WebSettings webSettings = webView.getSettings();
webSettings.setJavaScriptEnabled(false);
webView.loadUrl("https://your-url.com");
 */
        /*Use a Custom WebViewClient to Intercept URL Requests
        WebView webView = findViewById(R.id.webView);

webView.setWebViewClient(new WebViewClient() {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // List of known ad networks or ad URLs to block
        if (url.contains("doubleclick.net") || url.contains("ads.example.com")) {
            return true; // Block ad URL
        }
        return super.shouldOverrideUrlLoading(view, url);
    }
});

webView.loadUrl("https://your-url.com");
 */
        /*Modify WebView to Remove Ads via JavaScript
       WebView webView = findViewById(R.id.webView);
webView.getSettings().setJavaScriptEnabled(true);

String adBlockingScript =
    "javascript:(function() { " +
    "var ads = document.querySelectorAll('.ad, .advertisement, iframe'); " +
    "for (var i = 0; i < ads.length; i++) { " +
    "    ads[i].style.display = 'none'; " +
    "} " +
    "})()";

webView.setWebViewClient(new WebViewClient());
webView.loadUrl("https://your-url.com");
webView.evaluateJavascript(adBlockingScript, null);
 */
        /*Use WebView's Request Interceptor
        webView.setWebViewClient(new WebViewClient() {
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        String url = request.getUrl().toString();

        // Block requests to known ad servers
        if (url.contains("ads.example.com") || url.contains("doubleclick.net")) {
            return new WebResourceResponse("text/plain", "utf-8", null); // Block resource
        }

        return super.shouldInterceptRequest(view, request);
    }
});

webView.loadUrl("https://your-url.com");

        * */
        /*
                Intent in = getIntent();
        url = in.getStringExtra("Game_loc");
        if (TextUtils.isEmpty(url)) {
            Toast.makeText(getApplicationContext(), "URL not found", Toast.LENGTH_SHORT).show();
            finish();
        }
        webView = findViewById(R.id.webView);
        new AdBlockerWebView.init(this).initializeWebView(webView);
        webView.setWebViewClient(new Browser_home());
      //  initWebView();
        webView.loadUrl(url);
           private class Browser_home extends WebViewClient {
        Browser_home() {}
        @SuppressWarnings("deprecation")
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            return AdBlockerWebView.blockAds(view,url) ? AdBlocker.createEmptyResource() :
                    super.shouldInterceptRequest(view, url);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (AdBlocker.isAd(request.getUrl().toString())) {

                return true;
            } else {

                return false;
            }
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }
      */
        /**/
        mywebview.loadUrl("https://example.com");

    }
}