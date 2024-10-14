package com.example.comparacionlambda.Views

class SimulatedDialogFragment(
    private val addClient: (Int, String, String, String) -> Unit,
    private val deleteClient: (Int) -> Unit,
    private val updateClient: (Int, String, String, String) -> Unit,
    private val getRandomId: () -> Int
) {

    fun showInsertDialog() {
        // Simulamos captura de datos
        val newClientId = 105
        val newClientName = "Nuevo"
        val newClientApellidos = "Apellido"
        val newClientTelefono = "555555555"

        // Llamamos a la lambda de agregar
        addClient(newClientId, newClientName, newClientApellidos, newClientTelefono)
    }

    fun showUpdateDialog() {
        val clientId = getRandomId()
        if (clientId != -1) {
            // Llamamos a la lambda de actualización
            updateClient(clientId, "NombreActualizado", "ApellidoActualizado", "123123123")
        }
    }

    fun showDeleteDialog() {
        val clientId = getRandomId()
        if (clientId != -1) {
            // Llamamos a la lambda de eliminación
            deleteClient(clientId)
        }
    }
}
