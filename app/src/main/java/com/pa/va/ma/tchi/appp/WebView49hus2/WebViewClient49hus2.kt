package com.pa.va.ma.tchi.appp.WebView49hus2

import android.content.Intent
import android.net.http.SslError
import android.webkit.SslErrorHandler
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.pa.va.ma.tchi.appp.getPrefs49hus2
import com.pa.va.ma.tchi.appp.putLastPage49hus2

class WebViewClient49hus2 : WebViewClient() {
    override fun shouldOverrideUrlLoading(view49hus2: WebView?, request49hus2: WebResourceRequest?): Boolean {
        val prohibitedLinks49hus2 = listOf("facebook","instagram","youtube","booking","tripadvisor","maps")
        val modifiedLinks49hus2 = listOf ("mailto:","tel:")
        return when {
            modifiedLinks49hus2.find { request49hus2?.url.toString().startsWith(it) } != null -> {
                view49hus2?.context?.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        request49hus2?.url
                    )
                )
                true
            }
            prohibitedLinks49hus2.find { request49hus2?.url.toString().contains(it) } != null ->
                true
            else -> false
        }

    }

    override fun onPageFinished(view49hus2: WebView?, url49hus2: String?) {
        view49hus2?.context?.getPrefs49hus2()?.putLastPage49hus2(url49hus2?: return)
        super.onPageFinished(view49hus2, url49hus2)
    }

    override fun onReceivedSslError(view49hus2: WebView?, handler49hus2: SslErrorHandler?, error49hus2: SslError?) {
        handler49hus2?.proceed()
    }
}