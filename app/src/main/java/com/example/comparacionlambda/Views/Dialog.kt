package com.example.comparacionlambda.Views

import com.example.comparacionlambda.Data.RepositoryClient
import com.example.comparacionlambda.Logic.interfaces.OperationsInterface

class Dialog(private var listener: OperationsInterface) {

    private var action: Int = 0

    // Muestra el diálogo
    fun show(typeAction: Int) {
        listener?.let {
            val posibleName = "CAMBIADO"
            val posibleApellidos = "APELLIDO_CAMBIADO"
            val posibleTelefono = "TELEFONO_CAMBIADO"
            val posibleId = listener.devIdRandom() //me da un aleatorio. -1 está vacío para editar/borrar.
            when (typeAction) {
                0 -> onAccept() // Simulamos el botón aceptar de un nuevo

                1 -> if (posibleId != -1) onEdit(posibleId, posibleName, posibleApellidos, posibleTelefono)

                2 -> if (posibleId != -1) onDelete(posibleId)
            }
        }
    }

    private fun onDelete(id: Int) {
        listener!!.ClientDel(id)
    }

    private fun onEdit(id: Int, name: String, apellidos: String, telefono: String) {
        listener!!.ClientUpdate(id, name, apellidos, telefono)
    }

    private fun onAccept() {
        listener!!.ClientAdd(RepositoryClient.incrementPrimary(), "NUEVO CLIENTE", "NUEVO_APELLIDO", "000000000")
    }
}
