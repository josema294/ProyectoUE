package com.example.dameuncoctel.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dameuncoctel.databinding.FragmentFirstBinding
import com.example.dameuncoctel.databinding.FragmentSecondBinding
import com.example.dameuncoctel.model.CoctelDC
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    lateinit var _binding: FragmentSecondBinding
    private lateinit var arrayFavoritos: ArrayList<String>
    private lateinit var coctel: CoctelDC

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)



        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()

    }


  /*  private fun listadoFavoritos() {

        val userId = FirebaseAuth.getInstance().currentUser?.uid

        val query = FirebaseDatabase.getInstance().getReference("Usuario/$userId/Favoritos").orderByKey()
        Log.d("ZZZ",query.toString())

        query.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {

                   for (snapshot in snapshot.children) {


                       // Obtén el valor del nodo y añádelo al array
                       val favorito = snapshot.getValue(String::class.java)
                       if (favorito != null) {
                           arrayFavoritos.add(favorito)
                       }



                   }

                }

                Log.d("ZZZ",arrayFavoritos.toString())



            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })






    }*/


}