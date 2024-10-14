package com.example.comparacionlambda.Logic.interfaces

interface OperationsInterface {
    fun ClientAdd(id: Int, name: String, apellidos: String, telefono: String)
    fun ClientDel(id: Int)
    fun ClientUpdate(id: Int, name: String, apellidos: String, telefono: String)
    fun devIdRandom(): Int  // obtenemos un ID aleatorio
}
