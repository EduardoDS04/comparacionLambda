package com.example.comparacionlambda.Logic

import com.example.comparacionlambda.Data.RepositoryClient

class Controller {
    private val clientsList: MutableList<Client> = RepositoryClient.initialClients.toMutableList()

    fun addClient(client: Client) {
        clientsList.add(client)
    }

    fun updateClient(id: Int, name: String, apellidos: String, telefono: String): Boolean {
        val client = clientsList.find { it.id == id }
        client?.let {
            it.name = name
            it.apellidos = apellidos
            it.telefono = telefono
            return true
        }
        return false
    }

    fun deleteClient(id: Int): Boolean {
        return clientsList.removeAll { it.id == id }
    }

    fun getAllClients(): List<Client> {
        return clientsList
    }
}
