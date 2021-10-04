package com.pa.va.ma.tchi.appp

import android.content.Context
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.onesignal.OneSignal
import com.pa.va.ma.tchi.appp.Application49hus2.Application49hus2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun Context.oneSignal49hus2 () {
    OneSignal.initWithContext(this)
    OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
    OneSignal.setAppId(Application49hus2.ONESIGNAL_KEY_49hus)
}

fun Context.mobileAds49hus2 () {
    MobileAds.initialize(this)
    CoroutineScope(Dispatchers.IO).launch {
        try {
            Application49hus2.GAID49hus2 =
                AdvertisingIdClient.getAdvertisingIdInfo(this@mobileAds49hus2)?.id
        } catch (e49hus2: Exception) {

        }
    }
}

fun Context.appsFlyer49hus2 () {
    val applsFlyerConversion49hus2 = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(dataMap49hus2: MutableMap<String, Any>?) {
            dataMap49hus2?.run {

                Application49hus2.status49hus2 =
                    if (getValue(Application49hus2.APPSFLYER_STATUS_TAG_49hus2).toString() == "Organic") "Organic" else "Non-organic"

                val paramsArray49hus2 = mutableListOf<String>()
                getValue(Application49hus2.APPSFLYER_CAMPAIGN_TAG_49hus2)
                    .toString()
                    .split("||").drop(1)
                    .map {
                        paramsArray49hus2.add(it.split(":")[1])
                    }

                Application49hus2.key49hus2 = if (paramsArray49hus2.size >= 1) paramsArray49hus2[0] else Application49hus2.EMPTY_TAG_49hus2
                Application49hus2.sub249hus2 = if (paramsArray49hus2.size >= 2) paramsArray49hus2[1] else Application49hus2.EMPTY_TAG_49hus2
                Application49hus2.sub349hus2 = if (paramsArray49hus2.size >= 3) paramsArray49hus2[2] else Application49hus2.EMPTY_TAG_49hus2


                Application49hus2.mediaSource49hus2 = getValue(Application49hus2.APPSFLYER_MEDIA_SOURCE_TAG_49hus2).toString()
                Application49hus2.afChannel49hus2 = getValue(Application49hus2.APPSFLYER_AF_CHANNEL_TAG_49hus2).toString()
                Application49hus2.adGroup49hus2 = getValue(Application49hus2.APPSFLYER_ADGROUP_TAG_49hus2).toString()
                Application49hus2.adSet249hus2 = getValue(Application49hus2.APPSFLYER_ADSET_TAG_49hus2).toString()



            }
        }

        override fun onConversionDataFail(p0: String?) {
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {
        }

        override fun onAttributionFailure(p0: String?) {
        }
    }
    AppsFlyerLib.getInstance().run {
        Application49hus2.APPSFLYER_UID49hus2 = getAppsFlyerUID(this@appsFlyer49hus2)
        init(
            Application49hus2.APPSFLYER_KEY_49hus2,
            applsFlyerConversion49hus2,
            this@appsFlyer49hus2
        )
        start(this@appsFlyer49hus2)
    }
}

