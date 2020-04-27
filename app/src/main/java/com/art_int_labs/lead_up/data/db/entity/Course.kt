package com.art_int_labs.lead_up.data.db.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Course")
data class Course(
    val balls: Int,
    @SerializedName("count_lesson")
    val countLesson: Int,
    val heading: String,
    @PrimaryKey()
    val id: Int,
    val picture: String
)