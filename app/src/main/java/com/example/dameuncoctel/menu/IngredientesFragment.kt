package com.example.dameuncoctel.menu

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dameuncoctel.R
import com.example.dameuncoctel.databinding.FragmentIngredientesBinding
import com.example.dameuncoctel.model.CoctelDC
import com.example.dameuncoctel.model.FakeCoctelDC
import com.example.dameuncoctel.model.FakeDB
import com.example.dameuncoctel.resultado.AdaptadorRecyclerResultado
import com.example.dameuncoctel.resultado.ResultadoActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class IngredientesFragment : Fragment() {

    private var _binding: FragmentIngredientesBinding? = null
    private lateinit var ingredientesChipGroup: ChipGroup
    private lateinit var botonBuscar: Button
    private lateinit var simultaneidadSwitch: Switch
    private lateinit var mRootReferenceCoctail: DatabaseReference
    private lateinit var query: Query
    private lateinit var intent : Intent
    private lateinit var bundle2 : Bundle
    private var arrayResultado = ArrayList<CoctelDC>()


    //cocteles es la base de datos de cocteles
    private lateinit var cocteles: FakeDB


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentIngredientesBinding.inflate(inflater, container, false)

        botonBuscar = binding.buttonBuscarIngredientes
        ingredientesChipGroup = binding.ingredientesChipGroup
        simultaneidadSwitch = binding.switch1
        cocteles = FakeDB()


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Accede al string-array desde los recursos
        val ingredientesArray = resources.getStringArray(R.array.ingredientes)

        // Crea chips dinámicamente para cada ingrediente en el array
        val inflater = LayoutInflater.from(requireContext())
        for (ingrediente in ingredientesArray) {
            val chip = inflater.inflate(R.layout.chips_layout, ingredientesChipGroup, false) as Chip
            chip.text = ingrediente
            chip.isCheckable = true
            ingredientesChipGroup.addView(chip)
        }


        //Ejecutamos logica de busqueda de de cocteles con ingredientes

        botonBuscar.setOnClickListener {
            //arrayIngredientes son los ingredientes seleccionados por el usuario en la vista
            var arrayIngredientes: ArrayList<String> = ArrayList()
            //arraycocteles es el array de cocteles de la base de datos Fake


            //bucle recorer todos los chips y comprobar si estan marcados
            for (i in 0 until ingredientesChipGroup.childCount) {
                val chip = ingredientesChipGroup.getChildAt(i) as Chip
                if (chip.isChecked) {

                    arrayIngredientes.add(chip.text.toString())
                    Log.d("Ingrediente.chipmarcado", "Seleccionado el ingrediente ${chip.text}")
                }
            }

            AñadirItemslist(arrayIngredientes)

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //Ahora que hemos comprobado los ingredientes marcados, creamos array de cocteles que los contengan
    fun AñadirItemslist(arrayIngredientes: ArrayList<String>) {

        mRootReferenceCoctail = FirebaseDatabase.getInstance().getReference("coctail")
        query = mRootReferenceCoctail.orderByKey()
        var arrayResultado = ArrayList<CoctelDC>()

        query = mRootReferenceCoctail.orderByChild("coctail")
        query.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("Ingrediente.onDatachange", "HA entrado en onDatachange")

                if (snapshot.exists() && !simultaneidadSwitch.isChecked) {

                    for (ingrediente in arrayIngredientes) {
                        Log.d("ingrediente.bucleingredientes", ingrediente)

                        for (itmsnapshot in snapshot.children) {
                            val item = itmsnapshot.getValue(CoctelDC::class.java)

                            if (item?.strIngredient?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient2?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient3?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient4?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient5?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient6?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient7?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient8?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient9?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient10?.contains(
                                    ingrediente
                                ) ?: false
                            ) {

                                arrayResultado.add(item!!)
                                Log.d("Ingrediente.agregado", ingrediente)

                            }

                        }
                    }

                    intent = Intent(context, ResultadoActivity::class.java)
                    bundle2 = Bundle()
                    bundle2.putSerializable("resultadoIngredientes", arrayResultado)
                    intent.putExtra("resultadoIngredientes", bundle2)
                    Log.d("Ingrediente.arrayenviado", arrayResultado.size.toString())
                    startActivity(intent)
                    arrayResultado.clear()
                }




                if (snapshot.exists() && simultaneidadSwitch.isChecked) {

                    for (itmsnapshot in snapshot.children) {
                        val item = itmsnapshot.getValue(CoctelDC::class.java)
                        var tieneTodos = true
                        for (ingrediente in arrayIngredientes) {

                            Log.d("ingrediente.bucleingredientes", ingrediente)

                            if (item?.strIngredient?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient2?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient3?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient4?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient5?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient6?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient7?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient8?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient9?.contains(
                                    ingrediente
                                ) ?: false
                                || item?.strIngredient10?.contains(
                                    ingrediente
                                ) ?: false
                            ) {

                            } else {
                                tieneTodos = false
                                break
                            }
                        }

                        if (tieneTodos) {
                            arrayResultado.add(item!!)

                        }


                    }

                    intent = Intent(context, ResultadoActivity::class.java)
                    bundle2  = Bundle()
                    bundle2.putSerializable("resultadoIngredientes", arrayResultado)
                    intent.putExtra("resultadoIngredientes", bundle2)
                    Log.d("Ingrediente.arrayenviado", arrayResultado.size.toString())
                    startActivity(intent)
                    arrayResultado.clear()


                }



            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })


    }

}

