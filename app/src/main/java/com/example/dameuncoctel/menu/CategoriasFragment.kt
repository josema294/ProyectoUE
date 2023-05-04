package com.example.dameuncoctel.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.dameuncoctel.databinding.FragmentCategoriasBinding
import com.example.dameuncoctel.model.FakeDB


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CategoriasFragment : Fragment() {

    private var _binding: FragmentCategoriasBinding? = null
    private lateinit var buttonRon: ImageButton
    private lateinit var buttonGin: ImageButton
    private lateinit var buttonVodka: ImageButton
    private lateinit var buttonSin: ImageButton
    private lateinit var FakeDB

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCategoriasBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonRon = binding.cateogoriaRon
        buttonGin=binding.cateogoriaGin
        buttonVodka= binding.cateogoriaVodka
        buttonSin= binding.cateogoriaSin

        buttonRon.setOnClickListener {



        }









        }

    override fun onDestroyView() {
        super.onDestroyView()

    }


    }
