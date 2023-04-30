package com.example.dameuncoctel.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import androidx.viewpager.widget.ViewPager
import com.example.dameuncoctel.R
import com.example.dameuncoctel.menu.MenuActivity
import com.google.android.material.navigation.NavigationView

import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {


    private lateinit var appBarConfiguration: AppBarConfiguration

    lateinit var toolbar: Toolbar
    lateinit var navigation: NavigationView
    lateinit var drawer: DrawerLayout
    lateinit var viewPager: ViewPager
    lateinit var adaptadorPager: AdaptadorPager


    lateinit var tabs: TabLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        // Creamos instancias de los elementos del contentmain y el adaptador
        toolbar = findViewById(R.id.toolbar_2);
        viewPager = findViewById(R.id.view_pager);
        adaptadorPager = AdaptadorPager(supportFragmentManager)

        tabs = findViewById(R.id.tab);

        //Configuramops toolbar

        setSupportActionBar(toolbar)
        tabs.setupWithViewPager(viewPager)

        //Configurar pager

        viewPager.setAdapter(adaptadorPager)


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {

                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                true

            }
            else -> super.onOptionsItemSelected(item)
        }
    }

/*    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }*/
}