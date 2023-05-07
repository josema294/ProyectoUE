package com.example.dameuncoctel.model

import com.example.dameuncoctel.R

class FakeMisCocteles {


    private var arraydeMisCocteles: ArrayList<FakeCoctelDC>

    init {
        arraydeMisCocteles = ArrayList()
        agregarMisCocteles()
    }

    fun setMiCoctel(coctel: FakeCoctelDC) {

        arraydeMisCocteles.add(coctel)

    }

    private fun agregarMisCocteles() {

        arraydeMisCocteles.add(
            FakeCoctelDC(
                id = 1000,
                nombre = "Mi Coctel Example",
                foto = android.R.drawable.ic_menu_gallery, // Reemplazar con el ID de imagen correspondiente
                ingredientes = listOf("Ingrediente1", "Ingrediente2", "Ingrediente3"),
                instrucciones = "Este es el primer ejemplo de Coctel autocreado"
            )
        )


    }


    fun getMisCocteles(): ArrayList<FakeCoctelDC>? {


        return arraydeMisCocteles
    }
}