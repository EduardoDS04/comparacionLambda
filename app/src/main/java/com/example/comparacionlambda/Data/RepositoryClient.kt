package com.example.comparacionlambda.Data

import com.example.comparacionlambda.Logic.Client


class RepositoryClient {

    companion object {  //Sólo puedo tener un companion object por clase.
        var primary = 100
        //Actualizamos la lista con valores nuevos
        val arrayClient: List<Client> = listOf(
            Client(incrementPrimary(), "Santi","Velez", "92352902"),
            Client(incrementPrimary(), "Sonia", "Gomez", "723948"),
            Client(incrementPrimary(), "Guille", "Martinez", "9359632"),
            Client(incrementPrimary(), "Diego", "Diana", "9723472")
        )

        fun incrementPrimary() = primary++ //devuelvo la clave e incremento.
    }
}
