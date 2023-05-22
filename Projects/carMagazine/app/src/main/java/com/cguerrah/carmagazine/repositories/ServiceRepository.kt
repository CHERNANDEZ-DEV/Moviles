package com.cguerrah.carmagazine.repositories

import com.cguerrah.carmagazine.data.model.ServiceModel

class ServiceRepository(private val services: MutableList<ServiceModel>) {

    fun getServices() = services

    fun addServices(service: ServiceModel) = services.add(service)
}