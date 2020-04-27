package com.art_int_labs.lead_up.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.art_int_labs.lead_up.data.db.CourseDao
import com.art_int_labs.lead_up.data.db.NewsDao
import com.art_int_labs.lead_up.data.db.entity.Course
import com.art_int_labs.lead_up.data.db.entity.News
import com.art_int_labs.lead_up.data.network.AppNetworkSource
import com.art_int_labs.lead_up.data.db.entity.NewsAndCourses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class AppRepositoryImpl(
    val appNetworkSouce: AppNetworkSource,
    val courseDao: CourseDao,
    val newsDao: NewsDao
) : AppRepository {

    init{
        appNetworkSouce.downloadedNewsAndCourses.observeForever(Observer {
            persistNewsAndCourses(it)
        })
    }


    override suspend fun getCurrentCourses(): LiveData<List<Course>> {
        initData()
        return courseDao.getCourses()
    }

    override suspend fun getCurrentNews(): LiveData<List<News>> {
        initData()
        return newsDao.getNews()
    }


    private fun persistNewsAndCourses(newsAndCourses: NewsAndCourses){
        GlobalScope.launch(Dispatchers.IO) {
            newsDao.upsert(newsAndCourses.news)
            courseDao.upsert(newsAndCourses.courses)
        }
    }

    private suspend fun initData(){
        if (isFetchNeeded()) {
            fetchNewsAndCourses()
        }
    }
    private fun isFetchNeeded(): Boolean{
        val rand = Random.nextInt(0,2)
        return if (rand == 0) true
        else false
    }

    private suspend fun fetchNewsAndCourses(){
        appNetworkSouce.fetchNewsAndCourses()
    }

}