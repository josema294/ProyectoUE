package com.example.dameuncoctel.coctel

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.dameuncoctel.R
import layout.VistaDescripcionFragment

class AdaptadorPagerCoctel(fm: FragmentManager?,  private val myBundle: Bundle, context: Context) : FragmentPagerAdapter(fm!!) {
    var listaFragments: ArrayList<Fragment>
    var listaNombres: ArrayList<String>

    init {
        listaFragments = ArrayList()
        listaFragments.add(VistaDescripcionFragment())
        listaFragments.add(VistaIngredientesFragment())

        listaNombres = ArrayList()
        listaNombres.add(context.getString(R.string.pestana_coctel_Description))
        listaNombres.add(context.getString(R.string.pestana_coctel_Ingredients))

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
        val fragment = listaFragments[position]
        fragment.arguments = myBundle

        return fragment
    }


    override fun getCount(): Int {
        return listaFragments.size
    }


    override fun getPageTitle(position: Int): CharSequence {
        return listaNombres[position]
    }
}