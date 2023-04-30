package com.example.dameuncoctel.coctel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AdaptadorPagerCoctel(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
    var listaFragments: ArrayList<Fragment>
    var listaNombres: ArrayList<String>

    init {
        listaFragments = ArrayList()
        listaFragments.add(VistaIngredientesFragment())
        listaFragments.add(VistaDescripcionFragment())

        listaNombres = ArrayList()
        listaNombres.add("Descripcion")
        listaNombres.add("Ingredientes")

    }

    fun cambiarTexto() {




    }

    fun eliminarFragment(posicion: Int) {
        listaFragments.removeAt(posicion)
        notifyDataSetChanged()
    }

    fun addFragment(fragment: Fragment) {
        listaFragments.add(fragment)
        notifyDataSetChanged()
    }


    override fun getItem(position: Int): Fragment {
        return listaFragments[position]
    }


    override fun getCount(): Int {
        return listaFragments.size
    }


    override fun getPageTitle(position: Int): CharSequence {
        return listaNombres[position]
    }
}