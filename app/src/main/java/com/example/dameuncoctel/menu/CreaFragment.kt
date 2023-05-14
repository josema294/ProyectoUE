package com.example.dameuncoctel.menu

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.dameuncoctel.R
import com.example.dameuncoctel.databinding.FragmentCreaBinding
import com.example.dameuncoctel.model.CoctelDC
import com.example.dameuncoctel.model.FakeMisCocteles
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.util.UUID

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
    private lateinit var fakeMisCocteles: FakeMisCocteles

    private var _binding: FragmentCreaBinding? = null

    // Esta propiedad solo es válida entre onCreateView y onDestroyView.
    private val binding get() = _binding!!

    private lateinit var nombreTuCoctel: EditText
    private lateinit var descripcionTuCoctel: EditText
    private lateinit var ingrediente1TuCoctel: EditText
    private lateinit var ingrediente2TuCoctel: EditText
    private lateinit var ingrediente3TuCoctel: EditText
    private lateinit var ingrediente4TuCoctel: EditText
    private lateinit var ingrediente5TuCoctel: EditText
    private lateinit var ingrediente6TuCoctel: EditText
    private lateinit var ingrediente7TuCoctel: EditText
    private lateinit var medida1TuCoctel: EditText
    private lateinit var medida2TuCoctel: EditText
    private lateinit var medida3TuCoctel: EditText
    private lateinit var medida4TuCoctel: EditText
    private lateinit var medida5TuCoctel: EditText
    private lateinit var medida6TuCoctel: EditText
    private lateinit var medida7TuCoctel: EditText
    private lateinit var guardaTuCoctail: Button
    private lateinit var radioButtonAlcohol: RadioButton
    private lateinit var radioButtonNonAlcohol: RadioButton
    private lateinit var imageUri: Uri
    private var imageURL: String? = null
    private lateinit var buttonAddPhoto: Button
    private lateinit var getContent: ActivityResultLauncher<String>
    private lateinit var photoInfo: TextView
    private val contentResolver by lazy { requireActivity().contentResolver }


    lateinit var coctel: CoctelDC


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)


        }

        getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            // Guarda la URI de la imagen seleccionada
            uri?.let {
                imageUri = it
                // Obtener el nombre del archivo
                val fileName = getFileName(it)
                // Mostrar el nombre del archivo en el TextView
                photoInfo.text = fileName
            }
        }


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentCreaBinding.inflate(inflater, container, false)


        binding.guardaTuCoctail.setOnClickListener {


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
        buttonAddPhoto = binding.addTuFoto
        photoInfo = binding.photoInfo



        guardaTuCoctail.setOnClickListener {
            if (compruebaRellenado()) {
                guardaFireStore { imageUrl ->
                    // Este bloque de código se ejecutará cuando se haya obtenido la URL de la imagen
                    guardaTuCoctel(imageUrl)
                }
            }
        }


        buttonAddPhoto.setOnClickListener {

            getContent.launch("image/*")




        }




        return binding.root

    }

    private fun guardaFireStore(onSuccess: (String) -> Unit) {

        val filename = UUID.randomUUID().toString()
        val ref = FirebaseStorage.getInstance().getReference("/images/$filename")

        imageUri?.let {
            ref.putFile(it)
                .addOnSuccessListener {
                    Log.d(TAG, "Imagen subida exitosamente: ${it.metadata?.path}")

                    ref.downloadUrl.addOnSuccessListener {
                        Log.d(TAG, "Archivo ubicado en: $it")
                        // Guarda esta url en tu base de datos
                        imageURL = it.toString()
                        // Llama al callback con la URL de la imagen
                        onSuccess(imageURL!!)

                    }
                }
                .addOnFailureListener {
                    // Maneja cualquier error
                    Log.d(TAG, "Falló la subida de la imagen")
                    Snackbar.make(requireContext(),binding.root,getString(R.string.problem_uploading),Snackbar.LENGTH_SHORT)
                }
        }


    }

    @SuppressLint("Range")
    private fun getFileName(uri: Uri): String? {
        var result: String? = null
        if (uri.scheme == "content") {
            val cursor = contentResolver.query(uri, null, null, null, null)
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                }
            } finally {
                cursor?.close()
            }
        }
        if (result == null) {
            result = uri.path
            val cut = result?.lastIndexOf('/')
            if (cut != -1) {
                if (cut != null) {
                    result = result?.substring(cut + 1)
                }
            }
        }
        return result
    }





    private fun compruebaRellenado(): Boolean {

        //Comprobamos que al menos nombre descripcion y dos ingredientes estan rellenos

        if (nombreTuCoctel.text.isBlank()
            || descripcionTuCoctel.text.isBlank()
            || ingrediente1TuCoctel.text.isBlank()
            || medida1TuCoctel.text.isBlank()
            || medida2TuCoctel.text.isBlank()
            || ingrediente2TuCoctel.text.isBlank()
            || (!radioButtonAlcohol.isChecked && !radioButtonNonAlcohol.isChecked)

        ) {

            Snackbar.make(
                requireContext(),
                binding.root,
                getString(R.string.aviso_ingredientes),
                Snackbar.LENGTH_LONG
            ).show()

            return false
        } else {
            return true
        }


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


    private fun guardaTuCoctel(imageUrl: String) {

        var tuCoctelToGuardar: CoctelDC


        val strDrink: String = nombreTuCoctel.text.toString()
        val strInstructions: String = descripcionTuCoctel.text.toString()
        var strCategory: String? = null

        if (radioButtonAlcohol.isChecked) {
            strCategory = "Alcoholic"
        }

        if (radioButtonNonAlcohol.isChecked) {
            strCategory = "Non alcoholic"
        }

        val strDrinkThumb: String? = imageUrl
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
            /* strDrinkThumb = */strDrinkThumb,
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
        builder.setMessage(
            "${tuCoctelToGuardar.strDrink} \n" +
                    "${tuCoctelToGuardar.strInstructions}"
        )
        builder.setPositiveButton("Accept") { dialog, which ->

            val database = FirebaseDatabase.getInstance().reference

            // Crea una clave única para el coctel
            val key = database.child("coctail").push().key

            if (key == null) {
                Log.w(TAG, "No se pudo obtener una clave para el coctel")
                return@setPositiveButton
            }

            // Establece los valores del coctel en la base de datos de Firebase en el nodo coctail
            database.child("coctail").child(key).setValue(tuCoctelToGuardar)
                .addOnSuccessListener {
                    Log.d(TAG, "Coctel guardado con éxito en Cocteles-Firebase")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error al guardar el coctel en Cocteles-Firebase", e)
                }
            // Establece los valores del coctel en la base de datos de Firebase en el nodo Usuario
            database.child("Usuario").child( FirebaseAuth.getInstance().currentUser?.uid.toString()).child("OurCoctail").child(key).setValue(tuCoctelToGuardar)
                .addOnSuccessListener {
                    Log.d(TAG, "Coctel guardado con éxito en Usuario-OurCocteles-Firebase")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error al guardar el coctel en Usuario-OurCocteles-Firebase", e)
                }


            Snackbar.make(
                requireContext(),
                binding.root,
                getString(R.string.snack_acept),
                Snackbar.LENGTH_LONG
            ).show()

        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            Snackbar.make(
                requireContext(),
                binding.root,
                getString(R.string.snack_cancel),
                Snackbar.LENGTH_LONG
            ).show()
        }

        val dialog = builder.create()
        dialog.show()



    }
}