package com.example.dameuncoctel.menu

import android.os.Bundle
import android.view.Menu

import android.view.MenuItem
import android.view.View
import android.widget.TableLayout

import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.viewpager.widget.ViewPager

import com.example.dameuncoctel.R
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout


class MenuActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: Toolbar
    private lateinit var tab: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var adaptadorPager: AdaptadorPagerMenu



    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        toolbar = findViewById(R.id.toolbar_2)
        viewPager = findViewById(R.id.view_pager_menu);
        adaptadorPager = AdaptadorPagerMenu(supportFragmentManager)
        tab = findViewById(R.id.tab_menu)


        setSupportActionBar(toolbar)
        tab.setupWithViewPager(viewPager)

        //Configurar pager

        viewPager.setAdapter(adaptadorPager)

        //Recupera la llamada del menu del MainActivity y muestra el fragment correspondiente a la llamada
        val viewPager = findViewById<ViewPager>(R.id.view_pager_menu)
        viewPager.adapter = adaptadorPager

        val bundle = intent.extras
        val posicionViewPager = bundle?.getInt("posicionViewPager")
        viewPager.currentItem = posicionViewPager ?: 0

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Codigo para, desde el viewpager del menu, al hacer click en el item desplegable del menu,
        // movernos a su correspondiente fragment.
        when (item.itemId) {
            R.id.action_categorias -> viewPager.currentItem = 0
            R.id.action_ingredientes -> viewPager.currentItem = 1
            R.id.action_crea -> viewPager.currentItem = 2
            R.id.action_settings -> viewPager.currentItem = 3
            R.id.action_politica -> viewPager.currentItem = 4
            R.id.action_guia -> viewPager.currentItem = 5
            R.id.action_logout -> viewPager.currentItem = 6
        }
        return true
    }

    fun finalizarActividad () {

        finish()

    }

/*    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_menu)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }*/
}