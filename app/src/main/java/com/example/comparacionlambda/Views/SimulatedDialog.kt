package com.example.comparacionlambda.Views

import com.example.comparacionlambda.Logic.interfaces.OperationsInterface

class SimulatedDialogFragment(private val listener: OperationsInterface) {

    fun showInsertDialog() {
        // Simulamos captura de datos
        val newClientId = 105  // Por ejemplo, un ID nuevo
        val newClientName = "Nuevo"
        val newClientApellidos = "Apellido"
        val newClientTelefono = "555555555"

        // Usar el método adecuado de la interfaz para agregar el cliente
        listener.ClientAdd(newClientId, newClientName, newClientApellidos, newClientTelefono)
    }

    fun showUpdateDialog() {
        val clientId = listener.devIdRandom()
        if (clientId != -1) {
            // Usar el método adecuado de la interfaz para actualizar el cliente
            listener.ClientUpdate(clientId, "NombreActualizado", "ApellidoActualizado", "123123123")
        }
    }

    fun showDeleteDialog() {
        val clientId = listener.devIdRandom()
        if (clientId != -1) {
            // Usar el método adecuado de la interfaz para eliminar el cliente
            listener.ClientDel(clientId)
        }
    }
}
