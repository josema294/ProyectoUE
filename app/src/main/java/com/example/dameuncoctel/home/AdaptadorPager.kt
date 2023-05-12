package com.example.dameuncoctel.home

import android.app.Application
import android.content.Context
import android.provider.Settings.Global.getString
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.dameuncoctel.R

class AdaptadorPager(fm: FragmentManager?, context: Context) : FragmentPagerAdapter(fm!!) {
    var listaFragments: ArrayList<Fragment>
    var listaNombres: ArrayList<String>


    init {
        listaFragments = ArrayList()
        listaFragments.add(FirstFragment())
        listaFragments.add(SecondFragment())
        listaFragments.add(ThirdFragment())
        listaNombres = ArrayList()
        listaNombres.add(context.getString(R.string.pestana_home_Popular))
        listaNombres.add(context.getString(R.string.pestana_home_Favorites))
        listaNombres.add(context.getString(R.string.pestana_home_YourCocktails))
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