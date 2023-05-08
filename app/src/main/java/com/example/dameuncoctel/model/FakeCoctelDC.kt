package com.example.dameuncoctel.model

import java.io.Serializable

data class FakeCoctelDC

    (
        var id: Int,
        val nombre: String?,
        val foto: Int,
        val ingredientes: List<String>,
        val instrucciones: String?,

        )  : Serializable

