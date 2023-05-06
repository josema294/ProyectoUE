package com.example.dameuncoctel.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.dameuncoctel.R
import com.example.dameuncoctel.databinding.FragmentCreaBinding
import com.example.dameuncoctel.model.FakeCoctelDC
import com.example.dameuncoctel.model.FakeMisCocteles
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var fakeMisCocteles : FakeMisCocteles

    private var _binding: FragmentCreaBinding? = null
    // Esta propiedad solo es válida entre onCreateView y onDestroyView.
    private val binding get() = _binding!!

    private lateinit var nombreTuCoctel : EditText
    private lateinit var descripcionTuCoctel : EditText
    private lateinit var ingrediente1TuCoctel : EditText
    private lateinit var ingrediente2TuCoctel : EditText
    private lateinit var ingrediente3TuCoctel : EditText
    private lateinit var ingrediente4TuCoctel : EditText
    private lateinit var ingrediente5TuCoctel : EditText
    private lateinit var ingrediente6TuCoctel : EditText
    private lateinit var ingrediente7TuCoctel : EditText
    private lateinit var medida1TuCoctel : EditText
    private lateinit var medida2TuCoctel : EditText
    private lateinit var medida3TuCoctel : EditText
    private lateinit var medida4TuCoctel: EditText
    private lateinit var medida5TuCoctel : EditText
    private lateinit var medida6TuCoctel : EditText
    private lateinit var medida7TuCoctel : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)




        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentCreaBinding.inflate(inflater, container, false)


        binding.guardaTuCoctail.setOnClickListener {

            guardaTuCoctel()
        }

        //Creo Variables de las diferentes propiedades

        nombreTuCoctel = binding.nombreCoctail
        descripcionTuCoctel = binding.descripcionCoctail
        ingrediente1TuCoctel = binding.nombreIngrediente1
        ingrediente2TuCoctel = binding.nombreIngrediente2
        ingrediente3TuCoctel = binding.nombreIngrediente3
        ingrediente4TuCoctel = binding.nombreIngrediente4
        ingrediente5TuCoctel = binding.nombreIngrediente5
        ingrediente6TuCoctel = binding.nombreIngrediente6
        ingrediente7TuCoctel = binding.nombreIngrediente7
        medida1TuCoctel = binding.medidaIngrediente1
        medida2TuCoctel = binding.medidaIngrediente2
        medida3TuCoctel = binding.medidaIngrediente3
        medida4TuCoctel = binding.medidaIngrediente4
        medida5TuCoctel = binding.medidaIngrediente5
        medida6TuCoctel = binding.medidaIngrediente6
        medida7TuCoctel = binding.medidaIngrediente7

        return binding.root


    }

    private fun guardaTuCoctel (){

        var tuCoctelToGuardar : FakeCoctelDC
        var ingredientesTuCoctel: ArrayList<String> = ArrayList()

        //Agregamos al array de ingrediente los ingredientres que no se hayan dejado vacios

        binding.nombreIngrediente1.text?.toString()?.let { nombreIngrediente ->
            if (nombreIngrediente.isNotEmpty()) {
                ingredientesTuCoctel.add(nombreIngrediente)
            }}
        binding.nombreIngrediente2.text?.toString()?.let { nombreIngrediente ->
            if (nombreIngrediente.isNotEmpty()) {
                ingredientesTuCoctel.add(nombreIngrediente)
            }}
        binding.nombreIngrediente3.text?.toString()?.let { nombreIngrediente ->
            if (nombreIngrediente.isNotEmpty()) {
                ingredientesTuCoctel.add(nombreIngrediente)
            }}
        binding.nombreIngrediente4.text?.toString()?.let { nombreIngrediente ->
            if (nombreIngrediente.isNotEmpty()) {
                ingredientesTuCoctel.add(nombreIngrediente)
            }}
        binding.nombreIngrediente5.text?.toString()?.let { nombreIngrediente ->
            if (nombreIngrediente.isNotEmpty()) {
                ingredientesTuCoctel.add(nombreIngrediente)
            }}
        binding.nombreIngrediente6.text?.toString()?.let { nombreIngrediente ->
            if (nombreIngrediente.isNotEmpty()) {
                ingredientesTuCoctel.add(nombreIngrediente)
            }}
        binding.nombreIngrediente7.text?.toString()?.let { nombreIngrediente ->
            if (nombreIngrediente.isNotEmpty()) {
                ingredientesTuCoctel.add(nombreIngrediente)
            }}



        if (compruebaRellenado()) {

            tuCoctelToGuardar = FakeCoctelDC(
                1001,
                binding.nombreCoctail.text.toString(),
                android.R.drawable.ic_menu_gallery,
                ingredientesTuCoctel,
                binding.descripcionCoctail.text.toString()
            )

            fakeMisCocteles.setMiCoctel(tuCoctelToGuardar)

        }




    }

    fun compruebaRellenado (): Boolean {

        //Comprobamos que al menos nombre descripcion y dos ingredientes estan rellenos

        if (nombreTuCoctel.text.isBlank()
            || descripcionTuCoctel.text.isBlank()
            ||ingrediente1TuCoctel.text.isBlank()
            ||ingrediente2TuCoctel.text.isBlank()) {

            Snackbar.make(requireContext(),binding.root,getString(R.string.ingredientes_introducidos),Snackbar.LENGTH_LONG).show()

            return false
        }

        else { return true}


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CreaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}