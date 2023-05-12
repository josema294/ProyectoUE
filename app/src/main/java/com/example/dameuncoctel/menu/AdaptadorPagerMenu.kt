package com.example.dameuncoctel.menu

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.dameuncoctel.R

class AdaptadorPagerMenu(fm: FragmentManager?, context: Context) : FragmentPagerAdapter(fm!!) {
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





        listaNombres = ArrayList()

        listaNombres.add(context.getString(R.string.menu_categorias))
        listaNombres.add(context.getString(R.string.menu_ingredientes))
        listaNombres.add(context.getString(R.string.menu_crea))
        listaNombres.add(context.getString(R.string.menu_settings))
        listaNombres.add(context.getString(R.string.menu_privacy_policy))
        listaNombres.add(context.getString(R.string.menu_guide))
        
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