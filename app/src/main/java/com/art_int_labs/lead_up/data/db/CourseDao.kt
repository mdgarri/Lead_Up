package com.art_int_labs.lead_up.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.art_int_labs.lead_up.data.db.entity.Course


@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(courses: List<Course>)

    @Query("select * from Course ")
    fun getCourses():LiveData<List<Course>>

    @Query("select * from Course where id = :id ")
    fun getCourseById(id: Int):Course

    @Query("delete from Course")
    fun deleteAllCourses()

}