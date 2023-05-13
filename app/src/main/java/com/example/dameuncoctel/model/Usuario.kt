package com.example.dameuncoctel.model
import java.io.Serializable

data class Usuario(
    val id: String?,
    val Nombre: String?,
    val Email:String?,
    val OurCoctail: String?,
    val FavouritesCoctail: String?


): Serializable{
    // Constructor secundario sin argumentos requerido por Firebase
    constructor():this(null,null,null,null,null)
    //constructor(Nombre: String?, Email: String?) : this()
}


