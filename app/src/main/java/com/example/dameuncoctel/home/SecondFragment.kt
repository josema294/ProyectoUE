import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dameuncoctel.databinding.FragmentSecondBinding
import com.example.dameuncoctel.home.AdaptadorRecycler
import com.example.dameuncoctel.model.CoctelDC
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SecondFragment : Fragment() {

    private lateinit var _binding: FragmentSecondBinding
    private lateinit var arrayFavoritos: ArrayList<String>
    private lateinit var coctelesFavoritos: ArrayList<CoctelDC>
    lateinit var recycler: RecyclerView
    lateinit var adaptadorRecycler: AdaptadorRecycler

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrayFavoritos = ArrayList()
        coctelesFavoritos = ArrayList()

        listadoFavoritos()
        updateRecyclerView()


    }

    private fun listadoFavoritos() {
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        val query = FirebaseDatabase.getInstance().getReference("Usuario/$userId/Favoritos").orderByKey()

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                coctelesFavoritos.clear() // Limpiar la lista antes de agregar los favoritos actualizados

                for (coctelSnapshot in snapshot.children) {
                    val coctel = coctelSnapshot.getValue(CoctelDC::class.java)
                    if (coctel != null) {
                        coctelesFavoritos.add(coctel)
                    }
                }

                // Actualizar el RecyclerView o cualquier otra lógica para mostrar los cócteles favoritos
                // en el diseño de tu fragmento
                updateRecyclerView()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("SecondFragment", "Error al obtener listado de favoritos: ${error.message}")
            }
        })
    }


    private fun updateRecyclerView() {
        recycler = binding.recyclerFavoritos
        recycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        adaptadorRecycler = AdaptadorRecycler(requireContext(), coctelesFavoritos)
        recycler.adapter = adaptadorRecycler //  asignar el adaptador al RecyclerView
    }


    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
}
