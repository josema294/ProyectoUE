package com.example.dameuncoctel.coctel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dameuncoctel.R
import com.example.dameuncoctel.databinding.FragmentVistaDescripcionBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class VistaDescripcionFragment : Fragment() {

    private var _binding: FragmentVistaDescripcionBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentVistaDescripcionBinding.inflate(inflater, container, false)

        return binding.root




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}