package com.example.dameuncoctel.coctel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.dameuncoctel.R
import com.example.dameuncoctel.databinding.ActivityCoctelBinding
import com.example.dameuncoctel.model.CoctelDC
import com.example.dameuncoctel.model.Ingrediente
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CoctelActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityCoctelBinding
    private lateinit var toolbar: Toolbar
    private lateinit var adaptador: AdaptadorPagerCoctel
    private lateinit var viewPager: ViewPager
    private lateinit var bundle: Bundle
    private lateinit var fab: FloatingActionButton
    private var coctel: CoctelDC? = null
    lateinit var tabs: TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        //Se crea binding por defecto al crear activity en blanco, pero yo uso acceso a recursos R
        //Ya que el layout inflado no tiene los elementos a manejar directamente, tiene un content.
        binding = ActivityCoctelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recuperamos Bundle:
        bundle = intent.getBundleExtra("bundle")?: Bundle(0)

        //instanciamos elementos

        toolbar = findViewById(R.id.toolbar_2)
        adaptador = AdaptadorPagerCoctel(supportFragmentManager, bundle,this)
        viewPager = findViewById(R.id.view_pager_coctel)
        tabs = findViewById(R.id.tab_coctel)
        fab = binding.includeCoctel.fab


        //Hacemos las configuraciones de los elementos
        setSupportActionBar(toolbar)
        tabs.setupWithViewPager(viewPager)
        viewPager.setAdapter(adaptador)

        //Cambiamos el titulo del coctel al que pasamos del recycler y
        // recuperamos datos de el recycler con el coctel seleccionado

        coctel = bundle?.get("coctel") as CoctelDC?

        Log.d("bundle traido a CoctelActivity", bundle.toString())
        Log.d("coctel traido a CoctelActivity", coctel.toString())

        binding.includeCoctel.textViewTitulococtel.text = coctel?.strDrink
        if (coctel != null) {
            Glide.with(applicationContext).load(coctel!!.strDrinkThumb).into(binding.includeCoctel.imageView3)
        }

        fab.setOnClickListener {

            botonnFab()

        }



        //binding.includeCoctel.imageView3.setImageResource(coctel?.foto ?: R.drawable.caipirinha)




    }


    private fun botonnFab () {

        val userId = FirebaseAuth.getInstance().currentUser?.uid
        val cocktailId = coctel?.idDrink


        if (userId != null) {
            val databaseReference = FirebaseDatabase.getInstance().getReference("Usuario/$userId/Favoritos/$cocktailId")

            databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        // Si el coctel ya está en favoritos, lo eliminamos
                        databaseReference.removeValue()
                        Snackbar.make(binding.root,"prueba coctel ya existe, se limino de favoritos",1000).show()
                    } else {
                        // Si el coctel no está en favoritos, lo añadimos
                        databaseReference.setValue(cocktailId)
                        Snackbar.make(binding.root,"prueba se agrega el coctel a favoritos",1000).show()
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Aquí se manejan los errores
                }
            })
        }


    }


}


