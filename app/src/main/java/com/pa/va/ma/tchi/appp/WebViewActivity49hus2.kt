package com.pa.va.ma.tchi.appp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import android.webkit.ValueCallback
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.pa.va.ma.tchi.appp.WebView49hus2.WebView49hus2
import kotlinx.coroutines.*

class WebViewActivity49hus2 : AppCompatActivity() {

    private lateinit var scene149hus2: Scene
    private lateinit var scene249hus2: Scene

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_activity_container_49hus2)
        scene149hus2 = Scene.getSceneForLayout(
            findViewById(R.id.container_49hus2),
            R.layout.scene_web_view_activity49hus2,
            this
        )
        scene249hus2 = Scene.getSceneForLayout(
            findViewById(R.id.container_49hus2),
            R.layout.scene_for_wv_49hus2,
            this
        )
        scene149hus2.enter()
        setUptWebViewLayout49hus2()
    }

    private fun setUptWebViewLayout49hus2(){
        val webView49hus2 = findViewById<WebView49hus2>(R.id.wv_49hus2)
        webView49hus2.setWebChromeClient49hus2(this)
        findViewById<SwipeRefreshLayout>(R.id.srl_49hus2).let {
            it.setOnRefreshListener {
                webView49hus2.loadUrl(webView49hus2.url ?: return@setOnRefreshListener)
                it.isRefreshing = false
            }
        }
    }


    companion object {
        var filepathCallback49hus2: ValueCallback<Array<Uri>>? = null
        var uriView49hus2: Uri = Uri.EMPTY
    }

    override fun onActivityResult(
        requestCode49hus2: Int,
        resultCode49hus2: Int,
        data49hus2: Intent?
    ) {
        if (requestCode49hus2 == 0) {
            if (filepathCallback49hus2 != null) {
                val uriResult4kwe2 =
                    if (data49hus2 == null || resultCode49hus2 != RESULT_OK) null else data49hus2.data
                if (uriResult4kwe2 != null) {
                    filepathCallback49hus2?.onReceiveValue(arrayOf(uriResult4kwe2))
                } else {
                    filepathCallback49hus2?.onReceiveValue(arrayOf(uriView49hus2))
                }
                filepathCallback49hus2 = null
            }
            super.onActivityResult(requestCode49hus2, resultCode49hus2, data49hus2)
        }
    }

    override fun onResume() {
        startInternetCheck49hus2()
        super.onResume()
    }

    private fun startInternetCheck49hus2 () {
        lifecycleScope.launch {
            while (isActive) {
                delay(500)
                if (!isNetworkPresent49hus2()) {
                    animateNetworkMissing49hus2()
                    cancel()
                }
            }
        }
    }


    private fun isNetworkPresent49hus2(): Boolean {
        val connectivityManager49hus2 =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val networkCapabilities49hus2 =
                connectivityManager49hus2.getNetworkCapabilities(connectivityManager49hus2.activeNetwork)
                    ?: return false
            return networkCapabilities49hus2.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else {
            for (network49hus2 in connectivityManager49hus2.allNetworks) {
                connectivityManager49hus2.getNetworkInfo(network49hus2)?.let {
                    if (it.isConnected) return true
                }
            }
            return false
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun animateNetworkMissing49hus2() {
        TransitionManager.go(scene249hus2)
        val button49hus2 = findViewById<Button>(R.id.b_reconnect_49hus2)
        findViewById<SwipeRefreshLayout>(R.id.srl_49hus2).isEnabled = false
        findViewById<WebView49hus2>(R.id.wv_49hus2).setOnTouchListener { _49hus2, _49hus2_ -> true }
        button49hus2.setOnClickListener {
            if (isNetworkPresent49hus2()) {
                TransitionManager.go(scene149hus2, ChangeBounds())
                startInternetCheck49hus2()
                setUptWebViewLayout49hus2()
            }
        }
    }
}