package com.example.dameuncoctel.login

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.dameuncoctel.home.MainActivity
import com.example.dameuncoctel.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var botonSignIn: Button

    private lateinit var usuario: EditText
    private lateinit var pass: EditText
    private lateinit var intentprimero: Intent
   // lateinit var auth: FirebaseAuth;
// ...



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        /*// Initialize Firebase Auth
        auth = Firebase.auth*/

    }
    /*override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }*/


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val viewFragmentLogin = inflater.inflate(R.layout.fragment_login, container, false)

        botonSignIn = viewFragmentLogin.findViewById(R.id.button_Log_In)

        usuario = viewFragmentLogin.findViewById(R.id.editTextTextEmailAddress)
        pass = viewFragmentLogin.findViewById(R.id.editTextTextPassword)

        botonSignIn.setOnClickListener {

            if (usuario.text.isNotEmpty() && pass.text.isNotEmpty()) {
                //Consejo de borja lina de abajo
                FirebaseAuth.getInstance().signOut()
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    usuario.text.toString(),
                    pass.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(it.result.user?.email ?: "", ActivityLogin.ProviderType.BASIC)
                    } else {
                        shoeAlert()
                    }
                }
            }else{
                shoeAlertErrorEmpty()
            }
        }

        /*if (usuario.text.toString()=="test" && pass.text.toString() == "test") {

                intentprimero = Intent (context, MainActivity::class.java)
                startActivity(intentprimero)


            }

            else {

                Snackbar.make(viewFragmentLogin,"Login incorrecto", Snackbar.LENGTH_LONG).show()

            }*/






        return viewFragmentLogin
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    //Creamos una alerta por si el usuario no consigue loguearse
    private fun  shoeAlert(){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Error")
        builder.setMessage("You have an error with your authentication")
        builder.setPositiveButton("Accept",null)
        val dialog:AlertDialog=builder.create()
        dialog.show()
    }
    private fun  shoeAlertErrorEmpty(){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("ErrorEmpty")
        builder.setMessage("You must fill all fields")
        builder.setPositiveButton("Accept",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }
    //Mostramos la nueva pantalla
    private fun showHome(email:String, provider: ActivityLogin.ProviderType){
        intentprimero = Intent (context, MainActivity::class.java)
        startActivity(intentprimero)


    }
}