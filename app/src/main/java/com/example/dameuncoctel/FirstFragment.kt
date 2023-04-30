package com.example.dameuncoctel

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dameuncoctel.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    lateinit var listaCocteles: ArrayList<CoctelDC>
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


        //Creo lista de cocteles de prueba para testeo
        //TODO cambiar lista de cocteles de prueba por cocteles de la base de datos
        listaCocteles = ArrayList()
        listaCocteles.add(CoctelDC(1, "Mojito",R.drawable.mojito,"Cocktail","Highball glass",
            listOf("Light rum","Lime","Sugar","Mint","Soda water"),
            "Muddle mint leaves with sugar and lime juice. Add a splash of soda water and fill the glass with cracked ice. Pour the rum and top with soda water. Garnish and serve with straw.",
            listOf("2-3 oz ","Juice of 1 ","2 tsp","2-4"),
            listOf("IBA","ContemporaryClassic","Alcoholic","Vegan","Brunch")

        ))
        listaCocteles.add(CoctelDC(2, "Old-fashioned-Margarita", R.drawable.margarita,"Cocktail","Old-fashioned glass",
            listOf("Bourbon","Angostura bitters","Sugar","Water","Soda water"),
            "Place sugar cube in old fashioned glass and saturate with bitters, add a dash of plain water. Muddle until dissolved.Fill the glass with ice cubes and add whiskey.Garnish with orange twist, and a cocktail cherry.",
            listOf("4.5 cL","2 dashes","1 cube","dash"),
            listOf("IBA","Classic","Alcoholic","Savory","Expensive")
        ))
        listaCocteles.add(CoctelDC(3, "Long Island Tea-Caipiriña", R.drawable.caipirinha,"Cocktail","Highball glass",
            listOf("Vodka","Light rum","Gin","Tequila","Lemon","Coca-Cola"),
            "Combine all ingredients (except cola) and pour over ice in a highball glass. Add the splash of cola for color. Decorate with a slice of lemon and serve.",
            listOf("1/2 oz","1/2 oz","1/2 oz","1/2 oz","Juice of 1/2 ","1 splash"),
            listOf("Strong","StrongFlavor","Brunch","Vegetarian","Sour")
        ))
        listaCocteles.add(CoctelDC(4, "Negroni-Martini", R.drawable.martini,"Cocktail","Old-fashioned glass",
            listOf("Gin","Campari","Gin","Sweet Vermouth"),
            "Stir into glass over ice, garnish and serve.",
            listOf("1 oz","1 oz ","1 oz "),
            listOf("IBA","Classic")
        ))

        listaCocteles.add(CoctelDC(5, "Whiskey Sour-Piña Colada", R.drawable.pinacolada,"Cocktail","Old-fashioned glass",
            listOf("Blended whiskey","Lemon","Powdered sugar","Cherry","Lemon"),
            "Shake with ice. Strain into chilled glass, garnish and serve. If served 'On the rocks', strain ingredients into old-fashioned glass filled with ice.",
            listOf("2 oz","Juice of 1/2 ","1/2 tsp ","1","1/2 slice "),
            listOf("IBA","Classic","Alcoholic","ContemporaryClassic")
        ))
        listaCocteles.add(CoctelDC(6, "Dry Martini-Daiquiri", R.drawable.daiquiri,"Cocktail","Cocktail glass",
            listOf("Gin","Dry Vermouth","Olive","Cherry","Lemon"),
            "Straight: Pour all ingredients into mixing glass with ice cubes. Stir well. Strain in chilled martini cocktail glass. Squeeze oil from lemon peel onto the drink, or garnish with olive.",
            listOf("1 2/3 oz","1/3 oz ","1"),
            listOf("IBA","Classic","Alcoholic","Christmas")
        ))

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