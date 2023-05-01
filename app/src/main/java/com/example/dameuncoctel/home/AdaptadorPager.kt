package com.example.dameuncoctel.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AdaptadorPager(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
    var listaFragments: ArrayList<Fragment>
    var listaNombres: ArrayList<String>

    init {
        listaFragments = ArrayList()
        listaFragments.add(FirstFragment())
        listaFragments.add(SecondFragment())
        listaFragments.add(ThirdFragment())
        listaNombres = ArrayList()
        listaNombres.add("Populares")
        listaNombres.add("Favoritos")
        listaNombres.add("Tus Cocktails")
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