package com.example.dameuncoctel.login

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.dameuncoctel.R
import com.example.dameuncoctel.home.MainActivity
import com.example.dameuncoctel.model.CoctelDC
import com.example.dameuncoctel.model.Usuario
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

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
    private val GOOGLE_SING_IN = 100 // Constante para identificador Google Sing In
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var botonSignUp: Button
    private lateinit var nombre: EditText
    private lateinit var email: EditText
    private lateinit var pass: EditText
    private lateinit var intentprimero: Intent
    private lateinit var mRootReferenceCoctail: DatabaseReference
    private lateinit var CurrentUser:Usuario
    private lateinit var bundle: Bundle
    private lateinit var intent: Intent
    private lateinit var googleButton: Button


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
        googleButton = viewFragmentLogin.findViewById(R.id.buttonGoogle)

        botonSignUp.setOnClickListener{
            /**/if( email.text.isNotEmpty() && pass.text.isNotEmpty() && nombre.text.isNotEmpty()) {
                if(email.text.toString().contains('.') && email.text.toString().contains('@')){


                //Consejo de borja lina de abajo
                FirebaseAuth.getInstance().signOut()

                FirebaseAuth.getInstance().fetchSignInMethodsForEmail(email.text.toString()).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    val result = task.result
                    if (result?.signInMethods?.isEmpty() == true){
                        // La dirección de correo electrónico no está registrada en Firebase Authentication
                        // Puedes registrar un nuevo usuario con este correo electrónico
                      //Accedemos a la parte de identificación de Firebase para guardar al usuario nuevo
                        FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                            email.text.toString(),
                            pass.text.toString()
                        ).addOnCompleteListener {
                            if (it.isSuccessful) {
                                showHome(it.result.user?.email ?: "", ActivityLogin.ProviderType.BASIC)


                    } else {
                                showAlertErrorEmailFormat()
                            }

                    }

                } else {
                        // La dirección de correo electrónico ya está registrada en Firebase Authentication
                        // No puedes registrar un nuevo usuario con este correo electrónico
                        showAlertEmailAlreadyRegistred()

                }
                }
                }


            }else {
                showAlertErrorEmailFormat()
                }
            } else {
                showAlertErrorEmpty()
            }
            }

        googleButton.setOnClickListener{
            //Configuramos autenticacion

            val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            val googleClient= GoogleSignIn.getClient(requireActivity(),googleConf)
            googleClient.signOut()
            startActivityForResult(googleClient.signInIntent, GOOGLE_SING_IN )

        }

        // Inflate the layout for this fragment
        return viewFragmentLogin

        }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode,resultCode, data)
        if (requestCode == GOOGLE_SING_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)

                if(account != null){
                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            showHome(account.email ?: "", ActivityLogin.ProviderType.GOOGLE)
                        } else {
                            showAlertGoogle()
                        }
                    }
                }
            } catch (e: ApiException){
                showAlertEmailAlreadyRegistred()
            }

        }
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
    //Funcion Dialog de mail con formato incorrecto
    private fun  showAlertErrorEmailFormat(){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Error")
        builder.setMessage("Your email format is wrong")
        builder.setPositiveButton("Accept",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }
    //Funcion Dialog de campos sin rellenar
    private fun  showAlertErrorEmpty(){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("ErrorEmpty")
        builder.setMessage("You must fill all fields")
        builder.setPositiveButton("Accept",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }

    private fun showAlertEmailAlreadyRegistred(){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Error Mail Already Registred")
        builder.setMessage("This mail has already been registred before")
        builder.setPositiveButton("Accept",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()

    }
    private fun showAlertGoogle(){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Problem with Google")
        builder.setMessage("There was a problem with your Google Account")
        builder.setPositiveButton("Accept",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()

    }


    //Mostramos la nueva pantalla
    private fun showHome(email:String, provider: ActivityLogin.ProviderType){
        intentprimero = Intent (context, MainActivity::class.java)
        startActivity(intentprimero)


    }
    fun createUsuario(): Usuario {
        CurrentUser= Usuario(null,nombre.text.toString(),email.text.toString(),null,null)
        return CurrentUser
    }
    fun createUserDB(uidUser:String,usuarioEntrante:Usuario){
            Log.d("UID", uidUser.toString())
            //Accedemos a la colección de la base de datos
            mRootReferenceCoctail = FirebaseDatabase.getInstance().getReference("Usuario")
            //val empId = mRootReferenceCoctail.push().key!!
            val usuario = Usuario(uidUser,usuarioEntrante.Nombre,usuarioEntrante.Email,
                CoctelDC(),CoctelDC())
            mRootReferenceCoctail.child(uidUser.toString()).setValue(usuario)
            //mRootReferenceCoctail.addValueEventListener({"Nombre" to nombre.text.toString(),"Email" to email.text.toString()})
    }

}