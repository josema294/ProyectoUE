package com.example.dameuncoctel.resultado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dameuncoctel.R
import com.example.dameuncoctel.home.AdaptadorRecycler
import com.example.dameuncoctel.menu.MenuActivity
import com.example.dameuncoctel.model.FakeCoctelDC

class ResultadoActivity : AppCompatActivity() {


    private lateinit var arrayCocteles: ArrayList<FakeCoctelDC>
    private lateinit var intent: Intent
    private lateinit var bundle: Bundle
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        toolbar = findViewById(R.id.toolbar_2);
        setSupportActionBar(toolbar)


        intent = getIntent()
        bundle = intent.getBundleExtra("bundleCocteles")!!

        //Recuperamos el array con el resultado de cocteles
        //TODO arreglar el deprecated
        arrayCocteles = bundle?.getSerializable("cocteles") as ArrayList<FakeCoctelDC>


        val recycler = findViewById<RecyclerView>(R.id.recyclerViewResultado)
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adaptadorRecyclerResultado = AdaptadorRecyclerResultado(this, arrayCocteles)
        recycler.adapter = adaptadorRecyclerResultado


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
        // configuramos que al hacer click en un item, este realiza un intent al viewpager del MenuActivity por posicion
        when (item.itemId) {
            R.id.action_categorias -> {
                val intent = Intent(this, MenuActivity::class.java)
                val bundle = Bundle()
                bundle.putInt("posicionViewPager", 0)
                intent.putExtras(bundle)
                startActivity(intent)
                return true
            }

            R.id.action_ingredientes -> {
                val intent = Intent(this, MenuActivity::class.java)
                val bundle = Bundle()
                bundle.putInt("posicionViewPager", 1)
                intent.putExtras(bundle)
                startActivity(intent)
                return true
            }

            R.id.action_crea -> {
                val intent = Intent(this, MenuActivity::class.java)
                val bundle = Bundle()
                bundle.putInt("posicionViewPager", 2)
                intent.putExtras(bundle)
                startActivity(intent)
                return true
            }

            R.id.action_settings -> {
                val intent = Intent(this, MenuActivity::class.java)
                val bundle = Bundle()
                bundle.putInt("posicionViewPager", 3)
                intent.putExtras(bundle)
                startActivity(intent)
                return true
            }

            R.id.action_politica -> {
                val intent = Intent(this, MenuActivity::class.java)
                val bundle = Bundle()
                bundle.putInt("posicionViewPager", 4)
                intent.putExtras(bundle)
                startActivity(intent)
                return true
            }

            R.id.action_guia -> {
                val intent = Intent(this, MenuActivity::class.java)
                val bundle = Bundle()
                bundle.putInt("posicionViewPager", 5)
                intent.putExtras(bundle)
                startActivity(intent)
                return true
            }

            R.id.action_logout -> {
                val intent = Intent(this, MenuActivity::class.java)
                val bundle = Bundle()
                bundle.putInt("posicionViewPager", 6)
                intent.putExtras(bundle)
                startActivity(intent)
                return true
            }
            // ...
            else -> return super.onOptionsItemSelected(item)
        }
    }
}