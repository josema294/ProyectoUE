package layout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.dameuncoctel.databinding.FragmentVistaDescripcionBinding
import com.example.dameuncoctel.databinding.FragmentVistaIngredientesBinding
import com.example.dameuncoctel.model.CoctelDC


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class VistaDescripcionFragment : Fragment() {

    private var _binding: FragmentVistaDescripcionBinding? = null

    //private lateinit var coctel: CoctelDC


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var descripcion: TextView

    private lateinit var coctel: CoctelDC
    private var _ingredientesBinding: FragmentVistaIngredientesBinding? = null
    private val ingredientesBinding get() = _ingredientesBinding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentVistaDescripcionBinding.inflate(inflater, container, false)






        descripcion = binding.descripciNCoctel





        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val myBundle = arguments
        if (myBundle != null) {
            // Accede a los datos del Bundle
            coctel = myBundle.getSerializable("coctel") as CoctelDC
        }

        descripcion.text = coctel.strInstructions.toString()
        //ingredientes.text = "esto es una prueba"






    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}