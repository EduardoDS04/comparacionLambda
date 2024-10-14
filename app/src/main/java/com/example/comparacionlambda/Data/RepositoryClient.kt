package com.example.comparacionlambda.Data

import com.example.comparacionlambda.Logic.Client


class RepositoryClient {

    companion object {  //Sólo puedo tener un companion object por clase.
        var primary = 100

        val arrayClient: List<Client> = listOf(
            Client(incrementPrimary(), "Santi"),
            Client(RepositoryClient.incrementPrimary(), "Sonia"),
            Client(RepositoryClient.incrementPrimary(), "Guille"),
            Client(RepositoryClient.incrementPrimary(), "Diego")
        )

        fun incrementPrimary() = primary++ //devuelvo la clave e incremento.
    }
}
