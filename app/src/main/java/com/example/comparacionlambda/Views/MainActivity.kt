package com.example.comparacionlambda.Views

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.comparacionlambda.Logic.Client
import com.example.comparacionlambda.Logic.Controller
import com.example.comparacionlambda.Logic.interfaces.OperationsInterface
import com.example.comparacionlambda.R

class MainActivity : AppCompatActivity(), OperationsInterface {

    private lateinit var myButtonAdd: ImageView
    private lateinit var myButtonUpdate: ImageView
    private lateinit var myButtonDel: ImageView
    private lateinit var myDialog: Dialog
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
        myDialog = Dialog(this)

        myButtonAdd.setOnClickListener { myDialog.show(0) }
        myButtonUpdate.setOnClickListener { myDialog.show(1) }
        myButtonDel.setOnClickListener { myDialog.show(2) }
    }

    override fun ClientAdd(id: Int, name: String, apellidos: String, telefono: String) {
        val newClient = Client(id, name, apellidos, telefono)
        controller.ClientAddController(newClient)
        val msg = "El cliente con id = $id, ha sido insertado correctamente"
        Log.d(TAG, msg)
        showConsoleData(msg)
    }

    override fun ClientDel(id: Int) {
        val delete = controller.ClientDelController(id)
        val msg = if (delete) {
            "El cliente con id = $id, ha sido eliminado correctamente"
        } else {
            "El cliente con id = $id, no ha sido encontrado para eliminar"
        }
        Log.d(TAG, msg)
        showConsoleData(msg)
    }

    override fun ClientUpdate(id: Int, name: String, apellidos: String, telefono: String) {
        val update = controller.ClientUpdateController(id, name, apellidos, telefono)
        val msg = if (update) {
            "El cliente con id = $id, ha sido actualizado correctamente"
        } else {
            "El cliente con id = $id, no ha sido encontrado para actualizar"
        }
        Log.d(TAG, msg)
        showConsoleData(msg)
    }

    override fun devIdRandom(): Int {
        return controller.devIdRandom()
    }

    fun showConsoleData(msg: String) {
        Log.d(TAG, controller.showData())
    }
}
