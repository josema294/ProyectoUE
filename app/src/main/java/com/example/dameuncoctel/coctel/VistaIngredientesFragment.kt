package com.example.dameuncoctel.coctel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dameuncoctel.databinding.FragmentVistaDescripcionBinding
import com.example.dameuncoctel.databinding.FragmentVistaIngredientesBinding
import com.example.dameuncoctel.model.CoctelDC


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class VistaIngredientesFragment : Fragment() {

    private var _binding: FragmentVistaIngredientesBinding? = null
    private lateinit var coctel:CoctelDC

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {




        _binding = FragmentVistaIngredientesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myBundle = arguments
        if (myBundle != null) {
            // Accede a los datos del Bundle
            coctel = myBundle.getSerializable("coctel") as CoctelDC
        }

        binding.textviewIngredientes.text = "${coctel.ingredientes} ${coctel.medidas}"


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}