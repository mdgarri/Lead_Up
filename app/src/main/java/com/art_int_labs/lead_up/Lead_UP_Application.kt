package com.art_int_labs.lead_up

import android.app.Application
import com.art_int_labs.lead_up.data.db.AppDataBase
import com.art_int_labs.lead_up.data.db.CourseDao
import com.art_int_labs.lead_up.data.network.*
import com.art_int_labs.lead_up.data.repository.AppRepository
import com.art_int_labs.lead_up.data.repository.AppRepositoryImpl
import com.art_int_labs.lead_up.ui.main.MainViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class Lead_UP_Application: Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidModule(this@Lead_UP_Application))

        bind() from singleton { AppDataBase(instance()) }
        bind() from singleton { instance<AppDataBase>().courseDao() }
        bind() from singleton { instance<AppDataBase>().newsDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApiService(instance()) }
        bind<AppNetworkSource>() with singleton { AppNetworkSourceImpl(instance()) }
        bind<AppRepository>() with singleton { AppRepositoryImpl(instance(),instance(),instance()) }
        bind() from provider { MainViewModelFactory(instance())  }
    }
}