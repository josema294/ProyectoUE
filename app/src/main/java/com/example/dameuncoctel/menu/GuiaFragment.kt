package com.example.dameuncoctel.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.get
import com.example.dameuncoctel.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GuiaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GuiaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var buttonNext: Button
    private lateinit var buttonPrevius: Button
    private lateinit var frames: FrameLayout
    private  var pagina = 1
        private lateinit var vista1: LinearLayout
        private lateinit var vista2: LinearLayout
        private lateinit var vista3: LinearLayout
        private lateinit var vista4: LinearLayout
        private lateinit var vista5: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        //reseteamos vistas
        pagina = 1


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_guia, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonNext = view.findViewById(R.id.butto_next)
        buttonPrevius = view.findViewById(R.id.button_previus)
        frames = view.requireViewById(R.id.frameLayout)
        vista1 = view.findViewById(R.id.layout1)
        vista2 = view.findViewById(R.id.layout2)
        vista3 = view.findViewById(R.id.layout3)
        vista4 = view.findViewById(R.id.layout4)
        vista5 = view.findViewById(R.id.layout5)


        paginado()


        buttonNext.setOnClickListener {

            if(pagina<5) {
                pagina++
                paginado()
            }
        }

        buttonPrevius.setOnClickListener {
            if(pagina>1) {
                pagina--
                paginado()
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
         * @return A new instance of fragment GuiaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GuiaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun paginado (){

        when (pagina) {

            1 -> {
                vista1.visibility= View.VISIBLE
                vista2.visibility= View.INVISIBLE
                vista3.visibility= View.INVISIBLE
                vista4.visibility= View.INVISIBLE
                vista5.visibility= View.INVISIBLE
            }
            2 -> {
                vista1.visibility= View.INVISIBLE
                vista2.visibility= View.VISIBLE
                vista3.visibility= View.INVISIBLE
                vista4.visibility= View.INVISIBLE
                vista5.visibility= View.INVISIBLE
            }
            3 -> {
                vista1.visibility= View.INVISIBLE
                vista2.visibility= View.INVISIBLE
                vista3.visibility= View.VISIBLE
                vista4.visibility= View.INVISIBLE
                vista5.visibility= View.INVISIBLE
            }
            4 -> {
                vista1.visibility= View.INVISIBLE
                vista2.visibility= View.INVISIBLE
                vista3.visibility= View.INVISIBLE
                vista4.visibility= View.VISIBLE
                vista5.visibility= View.INVISIBLE
            }
            5 -> {
                vista1.visibility= View.INVISIBLE
                vista2.visibility= View.INVISIBLE
                vista3.visibility= View.INVISIBLE
                vista4.visibility= View.INVISIBLE
                vista5.visibility= View.VISIBLE
            }



        }



    }
}