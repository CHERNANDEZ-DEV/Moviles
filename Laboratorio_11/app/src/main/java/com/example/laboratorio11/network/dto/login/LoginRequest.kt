package com.example.laboratorio11.network.dto.login

// DTO(Data Transfer Object) es un patròn de diseño utilizado para representar y transferir datos entre diferentes capas
// Es una clase simple que contiene atributos y no contiene logica de negocio

class LoginRequest (

    val email: String,
    val password: String

    )