package com.example.comparacionlambda.Views

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.comparacionlambda.Logic.Client
import com.example.comparacionlambda.Logic.Controller
import com.example.comparacionlambda.R

class MainActivity : AppCompatActivity() {

    private lateinit var myButtonAdd: ImageView
    private lateinit var myButtonUpdate: ImageView
    private lateinit var myButtonDel: ImageView
    private val controller = Controller()

    companion object {
        const val TAG = "---SALIDA---"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myButtonAdd = findViewById(R.id.myButtonAdd)
        myButtonUpdate = findViewById(R.id.myButtomEdit)
        myButtonDel = findViewById(R.id.myButtomDel)

        // Definimos las lambdas para cada operación del CRUD
        val addClientLambda: (Int, String, String, String) -> Unit = { id, name, apellidos, telefono ->
            val newClient = Client(id, name, apellidos, telefono)
            controller.addClient(newClient)
            val msg = "El cliente con id = ${newClient.id}, ha sido insertado correctamente"
            Log.d(TAG, msg)
            showConsoleData()
        }

        val deleteClientLambda: (Int) -> Unit = { id ->
            val deleted = controller.deleteClient(id)
            val msg = if (deleted) {
                "El cliente con id = $id ha sido eliminado correctamente"
            } else {
                "El cliente con id = $id no existe para eliminar"
            }
            Log.d(TAG, msg)
            showConsoleData()
        }

        val updateClientLambda: (Int, String, String, String) -> Unit = { id, name, apellidos, telefono ->
            val updated = controller.updateClient(id, name, apellidos, telefono)
            val msg = if (updated) {
                "El cliente con id = $id, ha sido actualizado correctamente"
            } else {
                "El cliente con id = $id no existe para actualizar"
            }
            Log.d(TAG, msg)
            showConsoleData()
        }

        val getRandomIdLambda: () -> Int = {
            val client = controller.getAllClients().randomOrNull()
            client?.id ?: -1
        }

        //  lambdas a SimulatedDialogFragment
        val myDialog = SimulatedDialogFragment(addClientLambda, deleteClientLambda, updateClientLambda, getRandomIdLambda)

        myButtonAdd.setOnClickListener { myDialog.showInsertDialog() }
        myButtonUpdate.setOnClickListener { myDialog.showUpdateDialog() }
        myButtonDel.setOnClickListener { myDialog.showDeleteDialog() }
    }

    private fun showConsoleData() {
        Log.d(TAG, controller.getAllClients().toString())
    }
}
