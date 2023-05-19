package com.example.dameuncoctel.model

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import org.checkerframework.checker.formatter.qual.ReturnsFormat

class IngredientesList {

    lateinit var mRootReferenceCoctail  : DatabaseReference
    private val nodeList =ArrayList<String>()
    private lateinit var query : Query
    private lateinit var listaIngredientes: ArrayList<Ingrediente>
    private lateinit var listaIngredientesString: ArrayList<String>


    init{

        listaIngredientes = ArrayList()
        listaIngredientesString = ArrayList()
        AñadirItemslist(listaIngredientes)

    }

    fun daneIngredientes(): ArrayList<Ingrediente>{

        return  listaIngredientes
    }

    fun dameIngredientesStrings(): ArrayList<String> {

        for (ingrediente in listaIngredientes) {

            listaIngredientesString.add(ingrediente.strIngredient.toString())


        }

        return listaIngredientesString
    }


    fun AñadirItemslist(listaIngredientes : ArrayList<Ingrediente>): ArrayList<Ingrediente> {

        mRootReferenceCoctail = FirebaseDatabase.getInstance().getReference("ingredientes")
        query = mRootReferenceCoctail.orderByKey()
        query = mRootReferenceCoctail.orderByChild("ingredientes")
        query.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {
                    var ky: String = ""
                    var itnm: String = ""
                    var limit: Int = 0
                    for (itmsnapshot in snapshot.children) {
                        val item = itmsnapshot.getValue(Ingrediente::class.java)

                        listaIngredientes.add(item!!)
                        ky = itmsnapshot.key.toString()
                        itnm = item.strIngredient.toString()
                        println(ky + " nombre " + itnm)

                        /*limit = limit + 1
                        if (limit >= 20) {
                            break
                        }*/
                    }


                }

            }

            override fun onCancelled(error: DatabaseError) {
                //TODO("Not yet implemented")
            }


        })
        return listaIngredientes
    }


}