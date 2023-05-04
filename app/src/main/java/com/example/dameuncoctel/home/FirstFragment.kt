package com.example.dameuncoctel.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dameuncoctel.R
import com.example.dameuncoctel.databinding.FragmentFirstBinding
import com.example.dameuncoctel.model.CoctelDC
import com.example.dameuncoctel.model.FakeCoctelDC
import com.example.dameuncoctel.model.FakeDB

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    lateinit var listaCocteles: ArrayList<FakeCoctelDC>
    lateinit var recycler: RecyclerView
    lateinit var adaptadorRecycler: AdaptadorRecycler


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        listaCocteles = FakeDB().getCocteles()


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
        _binding = null
    }
}