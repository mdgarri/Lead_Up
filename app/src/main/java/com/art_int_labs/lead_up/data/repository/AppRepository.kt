package com.art_int_labs.lead_up.data.repository

import androidx.lifecycle.LiveData
import com.art_int_labs.lead_up.data.db.entity.Course
import com.art_int_labs.lead_up.data.db.entity.News

interface AppRepository {
    suspend fun getCurrentNews(): LiveData<List<News>>
    suspend fun getCurrentCourses(): LiveData<List<Course>>
}