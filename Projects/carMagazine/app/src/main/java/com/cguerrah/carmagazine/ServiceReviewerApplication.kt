package com.cguerrah.carmagazine

import android.app.Application
import com.cguerrah.carmagazine.data.services
import com.cguerrah.carmagazine.repositories.ServiceRepository

class ServiceReviewerApplication : Application() {
    val serviceRepository: ServiceRepository by lazy{
        ServiceRepository(services)
    }
}