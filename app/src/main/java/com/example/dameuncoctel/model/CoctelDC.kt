package com.example.dameuncoctel.model

import java.io.Serializable

data class CoctelDC(
    var id: Int,
    val nombre: String?,
    val foto: Int,
    val categoria: String?,
    val tipoVaso: String?,
    val ingredientes: List<String>,
    val instrucciones: String?,
    val medidas: List<String>,
    val tags: List<String>,

    )  : Serializable



