package com.example.comparacionlambda.Logic

// Añadimos los nuevos campos requeridos para el CRUD
data class Client(
    var id: Int,
    var name: String,
    var apellidos: String,
    var telefono: String
)
