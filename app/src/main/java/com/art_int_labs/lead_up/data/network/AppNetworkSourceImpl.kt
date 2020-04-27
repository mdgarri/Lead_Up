package com.art_int_labs.lead_up.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.art_int_labs.lead_up.data.internal.NoConnectivityException
import com.art_int_labs.lead_up.data.db.entity.NewsAndCourses

class AppNetworkSourceImpl(
    private val apiService: ApiService
) : AppNetworkSource {

    private var _downloadedNewsAndCourses = MutableLiveData<NewsAndCourses>()

    override val downloadedNewsAndCourses: LiveData<NewsAndCourses>
        get() = _downloadedNewsAndCourses

    override suspend fun fetchNewsAndCourses() {
        try{
            val fetchedNewsAndCourses =  apiService
                .getNewsAndCourses()
                .await().body()

            _downloadedNewsAndCourses.postValue(fetchedNewsAndCourses)
        }
        catch (ex: NoConnectivityException){
            Log.e("Connectivity","No internet connection",ex)
        }
    }
}