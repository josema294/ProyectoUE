package com.example.dameuncoctel.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dameuncoctel.databinding.FragmentTuscoctelesBinding
import com.example.dameuncoctel.model.CoctelDC
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TusCoctelesFragment : Fragment() {

    lateinit var _binding: FragmentTuscoctelesBinding
    private val binding get() = _binding!!

    lateinit var listaCocteles: ArrayList<CoctelDC>
    lateinit var recycler: RecyclerView
    lateinit var adaptadorRecycler: AdaptadorRecycler
    lateinit var mRootReferenceCoctail  : DatabaseReference
    private lateinit var query : Query


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTuscoctelesBinding.inflate(inflater, container, false)


        listaCocteles = ArrayList<CoctelDC>()

        fun AñadirItemslist(listaCocteles : ArrayList<CoctelDC>): ArrayList<CoctelDC> {

            mRootReferenceCoctail = FirebaseDatabase.getInstance().getReference("Usuario").child( FirebaseAuth.getInstance().currentUser?.uid.toString()).child("OurCoctail")
            query = mRootReferenceCoctail.orderByKey()
            query.addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {

                    if (snapshot.exists()) {
                        var ky: String = ""
                        var itnm: String = ""
                        //var limit: Int = 0
                        for (itmsnapshot in snapshot.children) {
                            val item = itmsnapshot.getValue(CoctelDC::class.java)

                            listaCocteles.add(item!!)
                            ky = itmsnapshot.key.toString()
                            itnm = item.strDrink.toString()
                            println("$ky nombre $itnm")
                        }
                    }


                        recycler = binding.recyclerCocktails
                        recycler.layoutManager =
                            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

                        adaptadorRecycler = AdaptadorRecycler(requireContext(), listaCocteles)
                        recycler.adapter = adaptadorRecycler //  asignar el adaptador al RecyclerView



                }

                override fun onCancelled(error: DatabaseError) {
                    //TODO("Not yet implemented")
                }


            })
            return listaCocteles
        }
        //Realizamos una query a la base de datos y lo añadimos a la lista de cocteles
        AñadirItemslist(listaCocteles)

        Log.d("Pueba tamaño",listaCocteles.size.toString())


        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}