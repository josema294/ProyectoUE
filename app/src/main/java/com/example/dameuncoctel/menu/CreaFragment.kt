package com.example.dameuncoctel.menu

import android.app.AlertDialog
import android.app.Dialog
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import com.example.dameuncoctel.R
import com.example.dameuncoctel.databinding.FragmentCreaBinding
import com.example.dameuncoctel.model.CoctelDC
import com.example.dameuncoctel.model.FakeCoctelDC
import com.example.dameuncoctel.model.FakeMisCocteles
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.FirebaseDatabase

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
    private lateinit var medida8TuCoctel : EditText
    private lateinit var guardaTuCoctail: Button
    private lateinit var radioButtonAlcohol : RadioButton
    private lateinit var radioButtonNonAlcohol : RadioButton
    lateinit var coctel:CoctelDC



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
        guardaTuCoctail = binding.guardaTuCoctail
        radioButtonAlcohol = binding.radioButtonAlcoholic
        radioButtonNonAlcohol = binding.radioButtonNonAlcoholic

        guardaTuCoctail.setOnClickListener {

            if (compruebaRellenado()) {

                guardaTuCoctel()

            }


        }



        return binding.root

    }

    private fun guardaTuCoctel (){

        var tuCoctelToGuardar : CoctelDC

        val strDrink: String = nombreTuCoctel.text.toString()
        val strInstructions: String = descripcionTuCoctel.text.toString()
        var strCategory: String? = null

        if (radioButtonAlcohol.isChecked) {
            strCategory = "Alcoholic"
        }

        if (radioButtonNonAlcohol.isChecked) {
            strCategory = "Non alcoholic"
        }




        val strIngredient: String = ingrediente1TuCoctel.text.toString()
        val strIngredient2: String = ingrediente2TuCoctel.text.toString()
        val strIngredient3: String = ingrediente3TuCoctel.text.toString()
        val strIngredient4: String = ingrediente4TuCoctel.text.toString()
        val strIngredient5: String = ingrediente5TuCoctel.text.toString()
        val strIngredient6: String = ingrediente6TuCoctel.text.toString()
        val strIngredient7: String = ingrediente7TuCoctel.text.toString()
        val strMeasure1: String = medida1TuCoctel.text.toString()
        val strMeasure2: String = medida2TuCoctel.text.toString()
        val strMeasure3: String = medida3TuCoctel.text.toString()
        val strMeasure4: String = medida4TuCoctel.text.toString()
        val strMeasure5: String = medida5TuCoctel.text.toString()
        val strMeasure6: String = medida6TuCoctel.text.toString()
        val strMeasure7: String = medida7TuCoctel.text.toString()




        tuCoctelToGuardar = CoctelDC(
            /*idDrink =*/ "CoctelCustom",
           /* strDrink =*/ strDrink,
           /* strDrinkThumb = */null,
           /* strGlass = */null,
            /*strAlcoholic*/strCategory,
            /*strIngredient = */strIngredient,
          /*  strIngredient2 = */strIngredient2,
           /* strIngredient3 = */strIngredient3,
          /*  strIngredient4 = */strIngredient4,
           /* strIngredient5 = */strIngredient5,
          /*  strIngredient6 =*/ strIngredient6,
           /* strIngredient7 = */strIngredient7,
          /*  strIngredient8 = */null,
          /*  strIngredient9 = */null,
          /*  strIngredient10 =*/ null,
            /*strMeasure1 = */strMeasure1,
            /*strMeasure2 = */strMeasure2,
          /*  strMeasure3 = */strMeasure3,
            /*strMeasure4 =*/ strMeasure4,
          /*  strMeasure5 = */strMeasure5,
           /* strMeasure6 = */strMeasure6,
           /* strMeasure7 = */strMeasure7,
            /*strMeasure8 =*/ null,
           /* strMeasure9 = */null,
          /*  strMeasure10 =*/ null,
           /* strInstructions =*/ strInstructions,
           /* strTags = */ null
        )

        val builder = AlertDialog.Builder(context)
        builder.setTitle(R.string.alert_title)
        builder.setMessage("${tuCoctelToGuardar.strDrink} \n" +
                "${tuCoctelToGuardar.strInstructions}")
        builder.setPositiveButton("Acept") { dialog, which ->

            val database = FirebaseDatabase.getInstance().reference

            // Crea una clave única para el coctel
            val key = database.child("coctail").push().key

            if (key == null) {
                Log.w(TAG, "No se pudo obtener una clave para el coctel")
                return@setPositiveButton
            }

            // Establece los valores del coctel en la base de datos de Firebase
            database.child("coctail").child(key).setValue(tuCoctelToGuardar)
                .addOnSuccessListener {
                    Log.d(TAG, "Coctel guardado con éxito en Firebase")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error al guardar el coctel en Firebase", e)
                }


            Snackbar.make(requireContext(),binding.root,getString(R.string.snack_acept),Snackbar.LENGTH_LONG).show()

        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            Snackbar.make(requireContext(),binding.root,getString(R.string.snack_cancel),Snackbar.LENGTH_LONG).show()
        }

        val dialog = builder.create()
        dialog.show()

    }

    fun compruebaRellenado (): Boolean {

        //Comprobamos que al menos nombre descripcion y dos ingredientes estan rellenos

        if (nombreTuCoctel.text.isBlank()
            || descripcionTuCoctel.text.isBlank()
            ||ingrediente1TuCoctel.text.isBlank()
            ||medida1TuCoctel.text.isBlank()
            ||medida2TuCoctel.text.isBlank()
            ||ingrediente2TuCoctel.text.isBlank()
            ||(!radioButtonAlcohol.isChecked && !radioButtonNonAlcohol.isChecked)

        ) {

            Snackbar.make(requireContext(),binding.root,getString(R.string.aviso_ingredientes),Snackbar.LENGTH_LONG).show()

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