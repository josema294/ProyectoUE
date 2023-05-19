package com.example.dameuncoctel.login

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class AdaptadorPagerLogin (fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {

    var listaFragments: ArrayList<Fragment> = ArrayList()
    var listaNombres: ArrayList<String> = ArrayList()


    init {

        listaFragments.add(LoginFragment())
        listaFragments.add(SignInFragment())
        listaNombres.add("Login")
        listaNombres.add("SignIn")

    }





    override fun getCount(): Int {
       return  listaFragments.size
    }

    override fun getItem(position: Int): Fragment {

        return  listaFragments[position]

    }


}