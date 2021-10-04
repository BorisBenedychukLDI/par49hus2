package com.pa.va.ma.tchi.appp.WebView49hus2

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.pa.va.ma.tchi.appp.getLastPage49hus2
import com.pa.va.ma.tchi.appp.getPrefs49hus2
import com.pa.va.ma.tchi.appp.getURL49hus2
@SuppressLint("ViewConstructor")
class WebView49hus2(context49hus2: Context, attributeSet49hus2: AttributeSet?) : WebView(context49hus2, attributeSet49hus2) {

    init {
        scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        settings.run {
            loadWithOverviewMode = true
            displayZoomControls = false
            domStorageEnabled = true
            mediaPlaybackRequiresUserGesture = false
            javaScriptEnabled = true
            loadsImagesAutomatically = true
            cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
            builtInZoomControls = true
            useWideViewPort = true
            displayZoomControls = false
        }
        webViewClient = WebViewClient49hus2()

        context49hus2.getPrefs49hus2().getLastPage49hus2().let { lastPage49hus2 ->
            if (lastPage49hus2 != null) {
                loadUrl(lastPage49hus2)
            } else {
                loadUrl(context49hus2.getPrefs49hus2().getURL49hus2()?: return@let)
                Log.d("TEST_URL", context49hus2.getPrefs49hus2().getURL49hus2()?: return@let)
            }
        }
    }

    fun setWebChromeClient49hus2 (activity49hus2: AppCompatActivity) {
        webChromeClient = WebChromeClient49hus2(activity49hus2)
    }
}