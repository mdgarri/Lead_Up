package com.art_int_labs.lead_up.data.network

import androidx.lifecycle.LiveData
import com.art_int_labs.lead_up.data.db.entity.NewsAndCourses

interface AppNetworkSource {

    val downloadedNewsAndCourses: LiveData<NewsAndCourses>

    suspend fun fetchNewsAndCourses()
}