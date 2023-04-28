package com.example.dameuncoctel.menu

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AdaptadorPagerMenu(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
    var listaFragments: ArrayList<Fragment>
    var listaNombres: ArrayList<String>

    init {
        listaFragments = ArrayList()
        listaFragments.add(CategoriasFragment())
        listaFragments.add(IngredientesFragment())
        listaFragments.add(CreaFragment())
        listaFragments.add(AjustesFragment())
        listaFragments.add(PoliticaFragment())
        listaFragments.add(GuiaFragment())
        listaFragments.add(LogoutFragment())




        listaNombres = ArrayList()
        listaNombres.add("Categorias")
        listaNombres.add("Filtros")
        listaNombres.add("Crea tu Coctel")
        listaNombres.add("Ajustes")
        listaNombres.add("Politica de privacidad")
        listaNombres.add("Guia de usuario")
        listaNombres.add(("Log Out"))




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