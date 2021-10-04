package com.pa.va.ma.tchi.appp

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

fun Context.getPrefs49hus2 (): SharedPreferences = getSharedPreferences("SP_49hus2",MODE_PRIVATE)

fun SharedPreferences.putURL49hus2 (str49hus2: String) = edit().putString("webURL_49hus2",str49hus2).apply()

fun SharedPreferences.putLastPage49hus2 (lastPage49hus2: String) = edit()
    .putString("lastPage_49hus2", lastPage49hus2).apply()

fun SharedPreferences.getURL49hus2 () = getString("webURL_49hus2", null)
fun SharedPreferences.getLastPage49hus2 () = getString("lastPage_49hus2", null)