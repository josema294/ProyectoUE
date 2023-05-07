package com.example.dameuncoctel.model

import java.io.Serializable

data class CoctelDC(
    var idDrink: String?,
    val strDrink: String?,
    val strDrinkThumb: String?,
    val tipoVaso: String?,
    val ingredientes: List<String>,
    val strInstructions: String?,
    val medidas: List<String>,
    val tags: List<String>,

    )  : Serializable{
    // Constructor secundario sin argumentos requerido por Firebase
    constructor() : this(null, null, null, null, emptyList(), null, emptyList(), emptyList())
}



