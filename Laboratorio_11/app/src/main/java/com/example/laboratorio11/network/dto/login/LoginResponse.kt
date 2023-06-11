package com.example.laboratorio11.network.dto.login

import com.google.gson.annotations.SerializedName

// Este DTO se utiliza para definir la estructura de la respuesta recibida de la API
// La anotacion @SerializedName establece la asociacion entre las claves del JSON y las propiedades de la clase

data class LoginResponse (
    @SerializedName("msg") val message: String,
    @SerializedName("token") val token: String
    )
