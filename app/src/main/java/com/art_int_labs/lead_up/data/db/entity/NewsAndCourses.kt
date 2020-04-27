package com.art_int_labs.lead_up.data.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.art_int_labs.lead_up.data.db.entity.Course
import com.art_int_labs.lead_up.data.db.entity.News


const val NEWSANDCOURSES_ID = 0

@Entity
data class NewsAndCourses(
    @Embedded(prefix = "courses_")
    val courses: List<Course>,
    @Embedded(prefix = "news_")
    val news: List<News>
){
    @PrimaryKey(autoGenerate = false)
    var id = NEWSANDCOURSES_ID
}