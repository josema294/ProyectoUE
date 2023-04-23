package com.example.dameuncoctel.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dameuncoctel.CoctelDC
import com.example.dameuncoctel.R
import com.example.dameuncoctel.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CategoriasFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    lateinit var listaCocteles: ArrayList<CoctelDC>
    lateinit var recycler: RecyclerView
    lateinit var adaptadorRecyclerMenu: AdaptadorRecyclerMenu


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)


        //Creo lista de cocteles de prueba para testeo
        //TODO cambiar lista de cocteles de prueba por cocteles de la base de datos
        listaCocteles = ArrayList()
        listaCocteles.add(CoctelDC(1, "Mojito", R.drawable.mojito))
        listaCocteles.add(CoctelDC(2, "Margarita", R.drawable.margarita))
        listaCocteles.add(CoctelDC(3, "Caipiriña", R.drawable.caipirinha))
        listaCocteles.add(CoctelDC(4, "Martini", R.drawable.martini))
        listaCocteles.add(CoctelDC(5, "Piña Colada", R.drawable.pinacolada))
        listaCocteles.add(CoctelDC(6, "Daiquiri", R.drawable.daiquiri))

        recycler = binding.recyclerCocktails
        recycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        adaptadorRecyclerMenu = AdaptadorRecyclerMenu(requireContext(), listaCocteles)
        recycler.adapter = adaptadorRecyclerMenu //  asignar el adaptador al RecyclerView

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