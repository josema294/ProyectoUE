package com.example.dameuncoctel.login

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.dameuncoctel.R
import com.example.dameuncoctel.home.MainActivity
import com.google.firebase.auth.FirebaseAuth

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignInFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignInFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var botonSignUp: Button
    private lateinit var nombre: EditText
    private lateinit var email: EditText
    private lateinit var pass: EditText
    private lateinit var intentprimero: Intent

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
        val viewFragmentLogin = inflater.inflate(R.layout.fragment_sign_in, container, false)

        botonSignUp= viewFragmentLogin.findViewById(R.id.PageSignUpButtonsing_up)
        nombre = viewFragmentLogin.findViewById(R.id.PageSignUpeditTextTextUserName)
        email = viewFragmentLogin.findViewById(R.id.PageSignUpeditTextTextEmailAddress)
        pass = viewFragmentLogin.findViewById(R.id.PageSignUpeditTextTextPassword)

        botonSignUp.setOnClickListener{
            if( email.text.isNotEmpty() && pass.text.isNotEmpty()) {
                //Consejo de borja lina de abajo
                FirebaseAuth.getInstance().signOut()
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    email.text.toString(),
                    pass.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(it.result.user?.email ?: "", ActivityLogin.ProviderType.BASIC)
                    } else {
                        shoeAlertErrorEmailFormat()
                    }
                }
            }else{
                shoeAlertErrorEmpty()
            }

        }
        // Inflate the layout for this fragment
        return viewFragmentLogin
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignInFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignInFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun  shoeAlertErrorEmailFormat(){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Error")
        builder.setMessage("Your email format is wrong")
        builder.setPositiveButton("Accept",null)
        val dialog: AlertDialog =builder.create()
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