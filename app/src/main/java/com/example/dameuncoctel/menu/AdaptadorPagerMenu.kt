package com.example.dameuncoctel.menu

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AdaptadorPagerMenu(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
    var listaFragments: ArrayList<Fragment>
    var listaNombres: ArrayList<String>

    init {
        listaFragments = ArrayList()
        listaFragments.add(IngredientesFragment())
        listaFragments.add(CategoriasFragment())

        listaNombres = ArrayList()
        listaNombres.add("Ingredientes")
        listaNombres.add("Categorias")

    }

    fun cambiarTexto() {

        /*for (i in listaFragments) {

            var temp : Fragment =  i



        }*/


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