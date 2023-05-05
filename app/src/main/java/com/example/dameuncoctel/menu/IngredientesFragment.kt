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
import com.example.dameuncoctel.R
import com.example.dameuncoctel.databinding.FragmentIngredientesBinding
import com.example.dameuncoctel.model.FakeCoctelDC
import com.example.dameuncoctel.model.FakeDB
import com.example.dameuncoctel.resultado.ResultadoActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class IngredientesFragment : Fragment() {

    private var _binding: FragmentIngredientesBinding? = null
    private lateinit var ingredientesChipGroup: ChipGroup
    private lateinit var botonBuscar: Button
    private lateinit var simultaneidadSwitch: Switch

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
            val arrayCocteles = cocteles.getCocteles()

            //bucle recorer todos los chips y comprobar si estan marcados
            for (i in 0 until ingredientesChipGroup.childCount) {
                val chip = ingredientesChipGroup.getChildAt(i) as Chip
                if (chip.isChecked) {

                    arrayIngredientes.add(chip.text.toString())
                    Log.d("Ingrediente", "Seleccionado el ingrediente ${chip.text}")
                }
            }

            //Ahora que hemos comprobado los ingredientes marcados, creamos array de cocteles que los contengan
            var arrayResultado: ArrayList<FakeCoctelDC> = ArrayList()

            //TODO ME gustaria pulir estra compleja bucles y condicionales

            for (coctel in arrayCocteles) {

                var contieneTodosLosIngredientesSeleccionados = true
                var contieneAlgunoDeLosIngredientes = false
                for (ingredienteSeleccionado in arrayIngredientes) {

                    if (coctel.ingredientes.contains(ingredienteSeleccionado)) {
                        contieneAlgunoDeLosIngredientes = true
                    }
                    if (!coctel.ingredientes.contains(ingredienteSeleccionado)) {
                        contieneTodosLosIngredientesSeleccionados = false

                    }


                }

                if (simultaneidadSwitch.isChecked) {

                    if (contieneTodosLosIngredientesSeleccionados) {
                        arrayResultado.add(coctel)
                        Log.d("CoctelResultado", coctel.nombre.toString())
                    }


                } else {
                    if (contieneAlgunoDeLosIngredientes) {
                        arrayResultado.add(coctel)
                        Log.d("CoctelResultado", coctel.nombre.toString())
                    }
                }


            }

            //Una vez tenemos el listado de cocteles a enviar lanzamos el intent:

            val bundle = Bundle()
            bundle.putSerializable("cocteles", arrayResultado)
            val intent = Intent(requireContext(), ResultadoActivity::class.java)
            intent.putExtra("bundleCocteles", bundle)

            startActivity(intent)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}