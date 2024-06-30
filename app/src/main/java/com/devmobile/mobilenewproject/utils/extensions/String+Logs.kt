package com.devmobile.mobilenewproject.utils.extensions

import android.util.Log

fun String.logErrorMessage(tag:String = "AppTag") {
    Log.e(tag, this)
}
