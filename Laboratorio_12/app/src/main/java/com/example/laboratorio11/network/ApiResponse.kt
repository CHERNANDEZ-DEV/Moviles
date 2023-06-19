package com.example.laboratorio11.network

import java.lang.Exception

/*
    Esta clase es  utilizada para representar las respuestas de una API de manera genèrica, permite manejar
    diferentes escenarios de respuesta de una manera estructurada y segura.

    La principal caracteristica de una selead class es que todas sus subclases son conocidas y limitadas.
*/

sealed class ApiResponse<T> {

    data class Success<T>(val data: T) : ApiResponse<T>()


    data class Error<T>(val exception: Exception) : ApiResponse<T>()


    data class ErrorWithMessage<T>(val message: String) : ApiResponse<T>()

}