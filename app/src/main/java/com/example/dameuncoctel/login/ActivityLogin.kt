package com.example.dameuncoctel.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.dameuncoctel.R
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ActivityLogin : AppCompatActivity() {

    //adaptadores y complementos
    lateinit var adaptadorPagerLogin:AdaptadorPagerLogin
    lateinit var viewPagerLogin: ViewPager
    lateinit var tabs: TabLayout

    //Tipo de autentificación que tenemos
    enum class ProviderType{
        BASIC
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //creando instancias de elemtos

        adaptadorPagerLogin = AdaptadorPagerLogin (supportFragmentManager)
        viewPagerLogin = findViewById(R.id.view_pagerLogin)
        tabs = findViewById(R.id.tabLogin)


        //configuracion de pager

        viewPagerLogin.setAdapter(adaptadorPagerLogin)

    }


}