package com.example.dameuncoctel.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import androidx.viewpager.widget.ViewPager
import com.example.dameuncoctel.R

import com.example.dameuncoctel.login.SignInFragment

import com.example.dameuncoctel.login.ActivityLogin

import com.example.dameuncoctel.menu.MenuActivity
import com.example.dameuncoctel.model.CoctelDC
import com.example.dameuncoctel.model.Usuario
import com.google.android.material.navigation.NavigationView

import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener



class MainActivity : AppCompatActivity() {


    private lateinit var appBarConfiguration: AppBarConfiguration

    lateinit var toolbar: Toolbar
    lateinit var navigation: NavigationView
    lateinit var drawer: DrawerLayout
    lateinit var viewPager: ViewPager
    lateinit var adaptadorPager: AdaptadorPager

    lateinit var mRootReferenceCoctail  : DatabaseReference

    private lateinit var query : Query


    lateinit var context: Context
    lateinit var intentGoStart: Intent
    lateinit var tabs: TabLayout




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        // Creamos instancias de los elementos del contentmain y el adaptador
        toolbar = findViewById(R.id.toolbar_2);
        viewPager = findViewById(R.id.view_pager);
        adaptadorPager = AdaptadorPager(supportFragmentManager,this)

        tabs = findViewById(R.id.tab);

        //Configuramops toolbar

        setSupportActionBar(toolbar)
        tabs.setupWithViewPager(viewPager)

        //Configurar pager

        viewPager.setAdapter(adaptadorPager)

        Log.d("uidddddddddddddddddd", FirebaseAuth.getInstance().currentUser?.uid.toString())
        mRootReferenceCoctail = FirebaseDatabase.getInstance().getReference("Usuario")
        query = mRootReferenceCoctail.orderByKey()
        query = mRootReferenceCoctail.orderByChild("Usuario")

        query.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    if (snapshot.exists()) {
                        var existe: Boolean =false
                        for (itmsnapshot in snapshot.children) {
                            val item = itmsnapshot.getValue(Usuario::class.java)
                            Log.d("Usuario",item!!.id.toString())
                            if (item!!.id.equals( FirebaseAuth.getInstance().currentUser?.uid.toString())
                            ) {
                                //Log.d("Usuario","Existeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee")
                                existe=true

                            } else {
                                //Log.d("Usuario",item!!.id.toString())
                                //No es de los populares

                            }
                        }
                        Log.d("queryyyy",existe.toString())
                        if(existe==false){

                            var uid=FirebaseAuth.getInstance().currentUser?.uid.toString()
                            val usuario = Usuario(uid,FirebaseAuth.getInstance().currentUser?.displayName.toString(),FirebaseAuth.getInstance().currentUser?.email.toString(),null,null)
                            mRootReferenceCoctail.child(uid).setValue(usuario)
                            Log.d("Usuario","Ha sido creado con éxito")
                        }
                        else{
                            Log.d("Usuario","Ya existe")
                        }
        }}

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })



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
                //Configuracion Logout realizando Intent al ActivityLogin
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
                    .setNegativeButton("Cancel") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
                return true
            }
            // ...
            else -> return super.onOptionsItemSelected(item)
        }
    }
    fun finalizarActividad () {

        finish()

    }

    /*    override fun onSupportNavigateUp(): Boolean {
            val navController = findNavController(R.id.nav_host_fragment_content_main)
            return navController.navigateUp(appBarConfiguration)
                    || super.onSupportNavigateUp()
        }*/
}
