package com.example.dameuncoctel.resultado

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dameuncoctel.R
import com.example.dameuncoctel.coctel.CoctelActivity
import com.example.dameuncoctel.home.AdaptadorRecycler
import com.example.dameuncoctel.model.CoctelDC

class AdaptadorRecyclerResultado(var contexto: Context, var listaDatos: ArrayList<CoctelDC>) :
    RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {


    class MyHolder(var view: View) : RecyclerView.ViewHolder(view) {

        var nombre: TextView
        var imagen: ImageView

        init {
            nombre = view.findViewById(R.id.nombre_item)
            imagen = view.findViewById(R.id.imagen_item)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorRecycler.MyHolder {
        var view = LayoutInflater.from(contexto).inflate(R.layout.recycler_view, parent, false)

        return AdaptadorRecycler.MyHolder(view)
    }

    override fun onBindViewHolder(holder: AdaptadorRecycler.MyHolder, position: Int) {
        var coctel: CoctelDC = listaDatos.get(position) as CoctelDC
        //holder.imagen.setImageResource(coctel.foto)
        //Cargamos la imagen seleccionada de su URL
        Glide.with(contexto).load(coctel.strDrinkThumb).into(holder.imagen)
        holder.nombre.setText(coctel.strDrink)

        //Comportamiento para ir a la vista del coctel


        holder.imagen.setOnClickListener {


            val intent = Intent(contexto, CoctelActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("coctel", coctel)
            intent.putExtra("bundle", bundle)

            contexto.startActivity(intent)



        }
        holder.nombre.setOnClickListener {


            val intent = Intent(contexto, CoctelActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("coctel", coctel)
            intent.putExtra("bundle", bundle)

            contexto.startActivity(intent)



        }
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }
}