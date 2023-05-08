package com.example.dameuncoctel.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dameuncoctel.databinding.FragmentThirdBinding
import com.example.dameuncoctel.model.CoctelDC
import com.example.dameuncoctel.model.Ingrediente

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ThirdFragment : Fragment() {

    lateinit var _binding: FragmentThirdBinding
    private val binding get() = _binding!!

    lateinit var listaCocteles: ArrayList<CoctelDC>
    lateinit var recycler: RecyclerView
    lateinit var adaptadorRecycler: AdaptadorRecycler

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        //listaCocteles = FakeMisCocteles().getMisCocteles()!!

        recycler = binding.recyclerCocktails
        recycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        adaptadorRecycler = AdaptadorRecycler(requireContext(), listaCocteles)
        recycler.adapter = adaptadorRecycler //  asignar el adaptador al RecyclerView

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}