package com.example.dameuncoctel.coctel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.viewpager.widget.ViewPager
import com.example.dameuncoctel.R
import com.example.dameuncoctel.databinding.ActivityCoctelBinding
import com.google.android.material.tabs.TabLayout

class CoctelActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityCoctelBinding
    private lateinit var toolbar: Toolbar
    private lateinit var adaptador: AdaptadorPagerCoctel
    private lateinit var viewPager: ViewPager
    lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        //Se crea binding por defecto al crear activity en blanco, pero yo uso acceso a recursos R
        //Ya que el layout inflado no tiene los elementos a manejar directamente, tiene un content.
        binding = ActivityCoctelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //instanciamos elementos

        toolbar = findViewById(R.id.toolbar_2)
        adaptador = AdaptadorPagerCoctel(supportFragmentManager)
        viewPager = findViewById(R.id.view_pager_coctel)
        tabs = findViewById(R.id.tab_coctel)

        //Hacemos las configuraciones de los elementos
        setSupportActionBar(toolbar)
        tabs.setupWithViewPager(viewPager)
        viewPager.setAdapter(adaptador)


    }


}


