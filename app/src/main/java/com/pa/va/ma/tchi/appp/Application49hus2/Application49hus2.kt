package com.pa.va.ma.tchi.appp.Application49hus2

import android.app.Application
import com.pa.va.ma.tchi.appp.appsFlyer49hus2
import com.pa.va.ma.tchi.appp.mobileAds49hus2
import com.pa.va.ma.tchi.appp.oneSignal49hus2

class Application49hus2 : Application (){

    override fun onCreate() {
        super.onCreate()
        oneSignal49hus2()
        appsFlyer49hus2()
        mobileAds49hus2()
    }

    companion object {
        var key49hus2: String? = null
        var sub249hus2: String? = null
        var sub349hus2: String? = null

        var adGroup49hus2: String? = null
        var adSet249hus2: String? = null
        var afChannel49hus2: String? = null
        var mediaSource49hus2: String? = null

        var aid49hus2: String? = null
        var APPSFLYER_UID49hus2: String? = null

        var status49hus2: String? = null

        const val EMPTY_TAG_49hus2 = "empty"


        const val APPSFLYER_KEY_49hus2 = "pJt7PYzwYpuB3j5BmWE5Tj"
        const val ONESIGNAL_KEY_49hus = "cdf636c7-f902-46e2-9f59-368fe140e20e"


        const val APPSFLYER_CAMPAIGN_TAG_49hus2 = "campaign"
        const val APPSFLYER_STATUS_TAG_49hus2 = "af_status"
        const val APPSFLYER_ADGROUP_TAG_49hus2 = "adgroup"
        const val APPSFLYER_ADSET_TAG_49hus2 = "adset"
        const val APPSFLYER_AF_CHANNEL_TAG_49hus2 = "af_channel"
        const val APPSFLYER_MEDIA_SOURCE_TAG_49hus2 = "media_source"
    }
}