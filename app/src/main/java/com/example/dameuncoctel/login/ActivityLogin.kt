package com.example.dameuncoctel.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.viewpager.widget.ViewPager
import com.example.dameuncoctel.MainActivity
import com.example.dameuncoctel.R
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

class ActivityLogin : AppCompatActivity() {

    //adaptadores y complementos
    lateinit var adaptadorPagerLogin:AdaptadorPagerLogin
    lateinit var viewPagerLogin: ViewPager
    lateinit var tabs: TabLayout



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