package com.example.dameuncoctel.resultado

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
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
import com.example.dameuncoctel.model.CoctelDC
import com.example.dameuncoctel.model.FakeCoctelDC
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class ResultadoActivity : AppCompatActivity() {


    private lateinit var arrayCocteles: ArrayList<CoctelDC>
    private lateinit var intent: Intent
    private var contexto :Context=this

    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var mRootReferenceCoctail  : DatabaseReference
    private val nodeList =ArrayList<String>()
    private lateinit var query : Query
    private lateinit var seleccionCategoria:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        toolbar = findViewById(R.id.toolbar_2);
        setSupportActionBar(toolbar)

        //Se vacia el array de cocteles para que cada vez que se entre se escriban sobre solo los datos correspondientes
        arrayCocteles = ArrayList()
        arrayCocteles.clear()


        intent = getIntent()
        val bundle: Bundle? = intent.getBundleExtra("bundleCocteles")

        //Recuperamos el array con el resultado de cocteles
        //TODO arreglar el deprecated
        seleccionCategoria = bundle?.getSerializable("categoria") as String

        fun AñadirItemslist(listaCocteles : ArrayList<CoctelDC>): ArrayList<CoctelDC> {

            mRootReferenceCoctail = FirebaseDatabase.getInstance().getReference("coctail")
            query = mRootReferenceCoctail.orderByKey()
            Log.d("loooooooog",seleccionCategoria)
            //query = mRootReferenceCoctail.child("strIngredient").equalTo("\uf8ff"+selecccionCategoria)//.orderByChild("strIngredient").equalTo("\uf8ff"+selecccionCategoria)
            query = mRootReferenceCoctail.orderByChild("coctail")
            query.addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {

                    if (snapshot.exists()) {
                        var ky: String = ""
                        var itnm: String = ""
                        var limit: Int = 0
                        for (itmsnapshot in snapshot.children) {
                            val item = itmsnapshot.getValue(CoctelDC::class.java)

                            if (item!!.strIngredient?.contains(seleccionCategoria) == true
                                || item!!.strIngredient2?.contains(seleccionCategoria) == true
                                || item!!.strIngredient3?.contains(seleccionCategoria) == true
                                || item!!.strIngredient4?.contains(seleccionCategoria) == true
                                || item!!.strIngredient5?.contains(seleccionCategoria) == true
                                || item!!.strIngredient6?.contains(seleccionCategoria) == true
                                || item!!.strIngredient7?.contains(seleccionCategoria) == true
                                || item!!.strIngredient8?.contains(seleccionCategoria) == true
                                || item!!.strIngredient9?.contains(seleccionCategoria) == true
                                || item!!.strIngredient10?.contains(seleccionCategoria) == true) {
                                listaCocteles.add(item!!)
                                ky = itmsnapshot.key.toString()
                                itnm = item.strDrink.toString()
                                println(ky + " nombre " + itnm)
                                // Procesar los datos que se encuentran en singleSnapshot
                            }else {
                                // La consulta no ha devuelto resultados
                            }
                        }
                    }


                            /*limit = limit + 1
                            if (limit >= 20) {
                                break
                            }*/
                    val recycler = findViewById<RecyclerView>(R.id.recyclerViewResultado)
                    recycler.layoutManager = LinearLayoutManager(contexto, LinearLayoutManager.VERTICAL, false)
                    val adaptadorRecyclerResultado = AdaptadorRecyclerResultado(contexto, arrayCocteles)
                    recycler.adapter = adaptadorRecyclerResultado


                    }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }




        })
            return listaCocteles
        }
        //Realizamos una query a la base de datos y lo añadimos a la lista de cocteles
        AñadirItemslist(arrayCocteles)



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