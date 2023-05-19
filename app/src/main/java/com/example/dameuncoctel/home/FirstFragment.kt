package com.example.dameuncoctel.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dameuncoctel.databinding.FragmentFirstBinding
import com.example.dameuncoctel.model.CoctelDC
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener




/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    lateinit var listaCocteles: ArrayList<CoctelDC>
    lateinit var recycler: RecyclerView
    lateinit var adaptadorRecycler: AdaptadorRecycler
    lateinit var mRootReferenceCoctail  : DatabaseReference

    private lateinit var query : Query


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)




        //Creo lista de cocteles de prueba para testeo
        //TODO cambiar lista de cocteles de prueba por cocteles de la base de datos
        listaCocteles = ArrayList<CoctelDC>()

        fun AñadirItemslist(listaCocteles : ArrayList<CoctelDC>): ArrayList<CoctelDC> {

            mRootReferenceCoctail = FirebaseDatabase.getInstance().getReference("coctail")
            query = mRootReferenceCoctail.orderByKey()
            query = mRootReferenceCoctail.orderByChild("coctail")
            query.addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {

                    if (snapshot.exists()) {
                        var ky: String = ""
                        var itnm: String = ""
                        //var limit: Int = 0
                        for (itmsnapshot in snapshot.children) {
                            val item = itmsnapshot.getValue(CoctelDC::class.java)
                            if(item!!.strDrink.equals("Mojito")
                                || item.strDrink.equals("Old Fashioned")
                                || item.strDrink.equals("Long Island Tea")
                                || item.strDrink.equals("Whiskey Sour")
                                || item.strDrink.equals("Dry Martini")
                                || item.strDrink.equals("Daiquiri")
                                || item.strDrink.equals("Margarita")
                                || item.strDrink.equals("Manhattan")
                                || item.strDrink.equals("Banana Daiquiri")
                                || item.strDrink.equals("Bloody Mary")
                                || item.strDrink.equals("Caipirinha")
                                || item.strDrink.equals("Cuba Libre")
                                || item.strDrink.equals("Havana Cocktail")
                                || item.strDrink.equals("Mai Tai")
                                || item.strDrink.equals("Sol Y Sombra")
                                || item.strDrink.equals("Tequila Sour")
                                || item.strDrink.equals("Imperial Cocktail")
                                || item.strDrink.equals("Sex on the Beach")
                                || item.strDrink.equals("Irish Cream")
                                || item.strDrink.equals("Egg-Nog - Classic Cooked")
                            ){
                            listaCocteles.add(item!!)
                            ky = itmsnapshot.key.toString()
                            itnm = item.strDrink.toString()
                            println("$ky nombre $itnm")}
                            else{
                                //No es de los populares
                            }

                            /*limit = limit + 1
                            if (limit >= 20) {
                                break
                            }*/
                        }
                        recycler = binding.recyclerCocktails
                        recycler.layoutManager =
                            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

                        adaptadorRecycler = AdaptadorRecycler(requireContext(), listaCocteles)
                        recycler.adapter = adaptadorRecycler //  asignar el adaptador al RecyclerView

                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    //TODO("Not yet implemented")
                }


            })
            return listaCocteles
        }
        //Realizamos una query a la base de datos y lo añadimos a la lista de cocteles
        AñadirItemslist(listaCocteles)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}