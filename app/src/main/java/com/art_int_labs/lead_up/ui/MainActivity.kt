package com.art_int_labs.lead_up.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.art_int_labs.lead_up.R
import com.art_int_labs.lead_up.data.network.ApiService
import com.art_int_labs.lead_up.data.network.AppNetworkSourceImpl
import com.art_int_labs.lead_up.data.network.ConnectivityInterceptorImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlin.time.ExperimentalTime

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    @ExperimentalTime
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolBar)

        navController = Navigation.findNavController(this,R.id.nav_host_fragment)

        bottom_nav.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this,navController)

//        val api = ApiService(
//            ConnectivityInterceptorImpl(this)
//        )
//        val netWR = AppNetworkSourceImpl(api)
//        CoroutineScope(IO).launch {
//            netWR.fetchNewsAndCourses()
//        }
//
//          netWR.downloadedNewsAndCourses.observe(this, Observer {
//              if (it == null) return@Observer
//              textView.text = it.news.toString()
//          })

    }
}
