package com.art_int_labs.lead_up.ui.main

import androidx.lifecycle.ViewModel
import com.art_int_labs.lead_up.data.internal.lazyDeferred
import com.art_int_labs.lead_up.data.repository.AppRepository

class MainViewModel(
    private val appRepository: AppRepository
) : ViewModel() {

    val news by lazyDeferred {
        appRepository.getCurrentNews()
    }

    val courses by lazyDeferred {
        appRepository.getCurrentCourses()
    }



}
