package com.example.dameuncoctel.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dameuncoctel.R
import com.example.dameuncoctel.databinding.FragmentIngredientesBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class IngredientesFragment : Fragment() {

    private var _binding: FragmentIngredientesBinding? = null
    private lateinit var ingredientesChipGroup: ChipGroup

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentIngredientesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Encuentra el ChipGroup en el layout
        val ingredientesChipGroup: ChipGroup = binding.ingredientesChipGroup

        // Accede al string-array desde los recursos
        val ingredientesArray = resources.getStringArray(R.array.ingredientes)

        // Crea chips dinámicamente para cada ingrediente en el array
        val inflater = LayoutInflater.from(requireContext())
        for (ingrediente in ingredientesArray) {
            val chip = inflater.inflate(R.layout.chips_layout, ingredientesChipGroup, false) as Chip
            chip.text = ingrediente
            chip.isCheckable = true
            ingredientesChipGroup.addView(chip)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}

