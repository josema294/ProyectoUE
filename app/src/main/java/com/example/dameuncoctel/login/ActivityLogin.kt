package com.example.dameuncoctel.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.example.dameuncoctel.AdaptadorPager
import com.example.dameuncoctel.R
import com.google.android.material.tabs.TabLayout

class ActivityLogin : AppCompatActivity() {


    lateinit var adaptadorPagerLogin:AdaptadorPagerLogin
    lateinit var viewPagerLogin: ViewPager
    lateinit var tabs: TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //creo instancia del pager

        adaptadorPagerLogin = AdaptadorPagerLogin (supportFragmentManager)
        viewPagerLogin = findViewById(R.id.view_pagerLogin)
        tabs = findViewById(R.id.tabLogin)

        //configuracion de pager

        viewPagerLogin.setAdapter(adaptadorPagerLogin)




    }
}