package com.example.dameuncoctel.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dameuncoctel.R
import com.example.dameuncoctel.coctel.CoctelActivity
import com.example.dameuncoctel.model.CoctelDC
import com.example.dameuncoctel.model.Ingrediente

class AdaptadorRecycler(var contexto: Context, var listaCoctelDC: ArrayList<CoctelDC>) :
    RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    lateinit var coctelListener: OnRecyclerCoctelListener

    init {
        //creamos listener de interfaz de callback
        //TODO comento el listener para la interfaz de callback, por ahora no hace falta.
        //coctelListener = contexto as OnRecyclerCoctelListener

    }



    class MyHolder(var view: View) : RecyclerView.ViewHolder(view) {

        var nombre: TextView
        var imagen: ImageView

        init {
            nombre = view.findViewById(R.id.nombre_item)
            imagen = view.findViewById(R.id.imagen_item)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        var view = LayoutInflater.from(contexto).inflate(R.layout.recycler_view, parent, false)

        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {


        var coctel: CoctelDC = listaCoctelDC.get(position) as CoctelDC
        //Cargamos la imagen seleccionada de su URL
        Glide.with(contexto).load(coctel.strDrinkThumb).into(holder.imagen)
       // holder.imagen.setImageResource(coctel.strDrinkThumb)
        holder.nombre.setText(coctel.strDrink)

        /*var coctel: FakeCoctelDC = listaDatos.get(position)
        holder.imagen.setImageResource(coctel.foto)
        holder.nombre.setText(coctel.nombre)
        develop*/

        //Comportamiento para ir a la vista del coctel
        //TODO interfaz de callback comentada
        //coctelListener.onCoctelSelected(coctel)

            holder.imagen.setOnClickListener {

                val intent = Intent(contexto, CoctelActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable("coctel", coctel)
                intent.putExtra("bundle", bundle)
                Log.d("valor del coctel", coctel.toString())
                Log.d("El valor del bundle",bundle.toString())
                contexto.startActivity(intent)
            }
        holder.nombre.setOnClickListener {

            val intent = Intent(contexto, CoctelActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("coctel", coctel)
            intent.putExtra("bundle", bundle)
            Log.d("valor del coctel", coctel.toString())
            Log.d("El valor del bundle",bundle.toString())
            contexto.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return listaCoctelDC.size
    }

    interface OnRecyclerCoctelListener {

        fun onCoctelSelected(coctel: Ingrediente)

    }
}