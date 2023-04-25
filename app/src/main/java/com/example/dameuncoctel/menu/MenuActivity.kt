package com.example.dameuncoctel.menu

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TableLayout
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.viewpager.widget.ViewPager
import com.example.dameuncoctel.AdaptadorPager

import com.example.dameuncoctel.R
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

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }


/*    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_menu)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }*/
}