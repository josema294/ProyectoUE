package com.example.dameuncoctel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorRecycler(var contexto: Context, var listaDatos: List<*>):
    RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    class MyHolder ( var view: View): RecyclerView.ViewHolder(view) {

        lateinit var nombre: TextView
        lateinit var imagen: ImageView


        init {
            nombre = view.findViewById(R.id.nombre_item)
            imagen = view.findViewById(R.id.imagen_item)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        var view = LayoutInflater.from(contexto).inflate(R.layout.recycler_view, parent,false)

        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        var coctel: CoctelDC = listaDatos.get(position) as CoctelDC
        holder.imagen.setImageResource(coctel.foto)
        holder.nombre.setText(coctel.nombre)


    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

}