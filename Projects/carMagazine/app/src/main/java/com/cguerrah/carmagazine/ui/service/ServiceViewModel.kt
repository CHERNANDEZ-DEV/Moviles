package com.cguerrah.carmagazine.ui.service

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.cguerrah.carmagazine.ServiceReviewerApplication
import com.cguerrah.carmagazine.data.model.ServiceModel
import com.cguerrah.carmagazine.repositories.ServiceRepository

class ServiceViewModel(private val repository: ServiceRepository) : ViewModel() {

    //Wraper que contiene variables de tipo MutableLiveData y referencia a los campos necesarios para crear un nuevo servicio.

    var date = MutableLiveData("")
    var mechanic = MutableLiveData("")
    var currentMileague = MutableLiveData("")
    var expectedMileague = MutableLiveData("")
    var status = MutableLiveData("")

    fun getServices() = repository.getServices()

    fun addServices(service: ServiceModel) = repository.addServices(service)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as ServiceReviewerApplication
                ServiceViewModel(app.serviceRepository)
            }
        }

        //Se identifican los estados que pueden tomar los datos y que el LiveData notificarà.

        const val SERVICE_CREATED = "Service created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }

    // Se verficar si alguno de los datos es NULL o vacio y se actualiza el estado de LiveData a Wrong Information

    private fun validateData(): Boolean{
        when{
            date.value.isNullOrEmpty() -> return false
            mechanic.value.isNullOrEmpty() -> return false
            currentMileague.value.isNullOrEmpty() -> return false
            expectedMileague.value.isNullOrEmpty() -> return false
        }
        return true
    }

    // Se limpian las variables LiveData a su estado inicial

    fun clearData(){
        date.value = ""
        mechanic.value = ""
        currentMileague.value = ""
        expectedMileague.value = ""
    }

    //Se debe limpiar el estado del LiveData

    fun clearStatus() {
        status.value = INACTIVE
    }

    // Para no exponer los datos, la creaciòn de un nuevo servicio se realiza dentro de este ViewModel

    fun createService(){
        if (!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        // Se verifica el estado de los objetos
        val service = ServiceModel(
            date.value!!,
            mechanic.value!!,
            currentMileague.value!!,
            expectedMileague.value!!
        )

        addServices(service)
        clearData()
        status.value = SERVICE_CREATED
    }
}
