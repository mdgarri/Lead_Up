package com.art_int_labs.lead_up.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import com.art_int_labs.lead_up.data.internal.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response


@Suppress("DEPRECATION")
class ConnectivityInterceptorImpl(
    context: Context
) : ConnectivityInterceptor {

    val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isInternetAvailable())
            throw NoConnectivityException()
        return chain.proceed(chain.request())
    }


    private fun isInternetAvailable(): Boolean{
        return true
    }
}