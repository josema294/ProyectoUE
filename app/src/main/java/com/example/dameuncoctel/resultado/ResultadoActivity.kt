package com.example.dameuncoctel.resultado

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dameuncoctel.R
import com.example.dameuncoctel.menu.MenuActivity
import com.example.dameuncoctel.model.CoctelDC
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class ResultadoActivity : AppCompatActivity() {


    private lateinit var arrayCocteles: ArrayList<CoctelDC>
    private lateinit var intent: Intent
    private var contexto: Context = this
    private lateinit var searchView: SearchView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var mRootReferenceCoctail: DatabaseReference
    private lateinit var query: Query
    private lateinit var seleccionCategoria: String
    private lateinit var recyclerViewResultado: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        toolbar = findViewById(R.id.toolbar_2)
        setSupportActionBar(toolbar)

        //Se vacia el array de cocteles para que cada vez que se entre se escriban sobre solo los datos correspondientes
        arrayCocteles = ArrayList()
        arrayCocteles.clear()

        recyclerViewResultado = findViewById(R.id.recyclerViewResultado)


        intent = getIntent()
        val bundle: Bundle? = intent.getBundleExtra("bundleCocteles") // de la pantalla decategorias
        val bundle2: Bundle? =
            intent.getBundleExtra("resultadoIngredientes") //De pantalle de ingredientes
        val bundle3: Bundle? = intent.getBundleExtra("bundlequery") //De la barra de busqueda

        //Recuperamos el array con el resultado de cocteles
        //TODO arreglar el deprecated
        if (bundle?.getSerializable("categoria") != null) {
            seleccionCategoria = bundle.getSerializable("categoria") as String

            fun AnadirItemslist(listaCocteles: ArrayList<CoctelDC>): ArrayList<CoctelDC> {

                mRootReferenceCoctail = FirebaseDatabase.getInstance().getReference("coctail")
                query = mRootReferenceCoctail.orderByKey()
                Log.d("loooooooog", seleccionCategoria)
                //query = mRootReferenceCoctail.child("strIngredient").equalTo("\uf8ff"+selecccionCategoria)//.orderByChild("strIngredient").equalTo("\uf8ff"+selecccionCategoria)
                query = mRootReferenceCoctail.orderByChild("coctail")
                query.addValueEventListener(object : ValueEventListener {

                    override fun onDataChange(snapshot: DataSnapshot) {

                        if (snapshot.exists()) {
                            var ky: String
                            var itnm: String
                            //var limit: Int = 0
                            for (itmsnapshot in snapshot.children) {
                                val item = itmsnapshot.getValue(CoctelDC::class.java)
                                item!!.strIngredient?.lowercase()
                                item.strIngredient2?.lowercase()
                                item.strIngredient3?.lowercase()
                                item.strIngredient4?.lowercase()
                                item.strIngredient5?.lowercase()
                                item.strIngredient6?.lowercase()
                                item.strIngredient7?.lowercase()
                                item.strIngredient8?.lowercase()
                                item.strIngredient9?.lowercase()
                                item.strIngredient10?.lowercase()
                                if (item.strAlcoholic?.equals(seleccionCategoria) == true) {
                                    listaCocteles.add(item)
                                    ky = itmsnapshot.key.toString()
                                    itnm = item.strDrink.toString()
                                    println(ky + " nombre " + itnm)
                                } else {
                                    if (item.strIngredient?.contains(seleccionCategoria) == true
                                        || item.strIngredient2?.contains(seleccionCategoria) == true
                                        || item.strIngredient3?.contains(seleccionCategoria) == true
                                        || item.strIngredient4?.contains(seleccionCategoria) == true
                                        || item.strIngredient5?.contains(seleccionCategoria) == true
                                        || item.strIngredient6?.contains(seleccionCategoria) == true
                                        || item.strIngredient7?.contains(seleccionCategoria) == true
                                        || item.strIngredient8?.contains(seleccionCategoria) == true
                                        || item.strIngredient9?.contains(seleccionCategoria) == true
                                        || item.strIngredient10?.contains(seleccionCategoria) == true
                                    ) {
                                        listaCocteles.add(item!!)
                                        ky = itmsnapshot.key.toString()
                                        itnm = item.strDrink.toString().lowercase()
                                        println(ky + " nombre " + itnm)
                                        // Procesar los datos que se encuentran en singleSnapshot
                                    } else {
                                        // La consulta no ha devuelto resultados
                                    }
                                }

                            }

                            val recycler = findViewById<RecyclerView>(R.id.recyclerViewResultado)
                            recycler.layoutManager =
                                LinearLayoutManager(contexto, LinearLayoutManager.VERTICAL, false)
                            val adaptadorRecyclerResultado =
                                AdaptadorRecyclerResultado(contexto, arrayCocteles)
                            recycler.adapter = adaptadorRecyclerResultado


                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }


                })
                return listaCocteles
            }
            //Realizamos una query a la base de datos y lo añadimos a la lista de cocteles
            AnadirItemslist(arrayCocteles)


        }

        if (bundle2 != null) {

            val seleccionCoctelesIngredientesList =
                bundle2?.getSerializable("resultadoIngredientes") as ArrayList<CoctelDC>

            val recycler = findViewById<RecyclerView>(R.id.recyclerViewResultado)
            recycler.layoutManager =
                LinearLayoutManager(contexto, LinearLayoutManager.VERTICAL, false)
            val adaptadorRecyclerResultado =
                AdaptadorRecyclerResultado(contexto, seleccionCoctelesIngredientesList)
            recycler.adapter = adaptadorRecyclerResultado


        }

        if (bundle3 != null) {
            val searchQuery = bundle3.getString("query", "default").lowercase().capitalize()

            val cocktailNames: ArrayList<CoctelDC> = ArrayList()


            val database = FirebaseDatabase.getInstance().getReference("coctail")
            val resultadoQuery =
                database.orderByChild("strDrink").startAt(searchQuery).endAt(searchQuery + "\uf8ff")

            resultadoQuery.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    for (coctelSnapshot in dataSnapshot.children) {
                        val coctel = coctelSnapshot.getValue(CoctelDC::class.java)
                        coctel?.let {
                            cocktailNames.add(it)
                            Log.i("Coctel", it.strDrink!!)
                        }
                    }

                    val recycler = findViewById<RecyclerView>(R.id.recyclerViewResultado)
                    recycler.layoutManager =
                        LinearLayoutManager(contexto, LinearLayoutManager.VERTICAL, false)
                    val adaptadorRecyclerResultado =
                        AdaptadorRecyclerResultado(contexto, cocktailNames)
                    recycler.adapter = adaptadorRecyclerResultado



                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("Firebase", "Error: ${error.message}")
                }

            })
        }


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


    fun performSearch(query: String) {

        searchView.clearFocus()

        // Aquí implementas el código para lanzar tu Activity de resultados.
        val intent = Intent(this, ResultadoActivity::class.java)
        val bundle = Bundle()
        bundle.putString("query", query)
        intent.putExtra("bundlequery", bundle)
        startActivity(intent)
    }


}