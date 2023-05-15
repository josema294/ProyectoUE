package com.example.dameuncoctel.menu

import android.content.Intent
import android.os.Bundle
import android.view.Menu

import android.view.MenuItem
import android.view.View
import android.widget.TableLayout
import androidx.appcompat.app.AlertDialog

import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.viewpager.widget.ViewPager

import com.example.dameuncoctel.R
import com.example.dameuncoctel.login.ActivityLogin
import com.example.dameuncoctel.resultado.ResultadoActivity
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth


class MenuActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: Toolbar
    private lateinit var tab: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var adaptadorPager: AdaptadorPagerMenu
    private lateinit var searchView: SearchView
    private lateinit var intentGoStart: Intent



    override fun onCreate(savedInstanceState: Bundle?) {

        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        toolbar = findViewById(R.id.toolbar_2)
        setSupportActionBar(toolbar)
        invalidateOptionsMenu()
        viewPager = findViewById(R.id.view_pager_menu);
        adaptadorPager = AdaptadorPagerMenu(supportFragmentManager, this)
        tab = findViewById(R.id.tab_menu)
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

        // Buscador de toolbar
        val searchItem = menu.findItem(R.id.action_search)

        searchView = searchItem?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // User pressed the search button
                performSearch(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Codigo para, desde el viewpager del menu, al hacer click en el item desplegable del menu,
        // movernos a su correspondiente fragment. Log out para cerrar sesion con cuadro de dialogo
        when (item.itemId) {
            R.id.action_categorias -> viewPager.currentItem = 0
            R.id.action_ingredientes -> viewPager.currentItem = 1
            R.id.action_crea -> viewPager.currentItem = 2
            R.id.action_settings -> viewPager.currentItem = 3
            R.id.action_politica -> viewPager.currentItem = 4
            R.id.action_guia -> viewPager.currentItem = 5
            R.id.action_logout -> {
                AlertDialog.Builder(this)
                    .setMessage("Are you sure you want to log out?")
                    .setPositiveButton("Accept"){dialog, _ ->
                        FirebaseAuth.getInstance().signOut()
                        intentGoStart= Intent(this, ActivityLogin::class.java)
                        intentGoStart.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intentGoStart)
                        (this).finalizarActividad()

                        dialog.dismiss()
                    }
                    .setNegativeButton("Cancel"){dialog,_ ->
                        //CODE ACCION////
                        dialog.dismiss()
                    }
                    .show()
                return true
            }
        }
        return true
    }

    fun finalizarActividad () {

        finish()

    }


    fun performSearch(query: String) {

        searchView.clearFocus()

        // Aquí implementas el código para lanzar tu Activity de resultados.
        val intent = Intent(this, ResultadoActivity::class.java)
        val bundle = Bundle()
        bundle.putString("query",query)
        intent.putExtra("bundlequery", bundle)
        startActivity(intent)
    }





}


