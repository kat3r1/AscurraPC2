package com.example.ascurrapc2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ascurrapc2.R
import com.example.ascurrapc2.model.EquipoModel
import com.squareup.picasso.Picasso

class EquipoAdapter (private var lvEquipos: List<EquipoModel>): RecyclerView.Adapter<EquipoAdapter.ViewHolder>(){

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val etUrlLogo: ImageView = itemView.findViewById(R.id.imgEquipo)
        val equipoName: TextView = itemView.findViewById(R.id.txtNombreEquipo)
        val posicion: TextView = itemView.findViewById(R.id.txtPosicion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipoAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_equipo, parent, false))



           }

    override fun onBindViewHolder(holder: EquipoAdapter.ViewHolder, position: Int) {


        val itemEquipo = lvEquipos[position]
        holder.equipoName.text = itemEquipo.equipoName
        holder.posicion.text = itemEquipo.posicion
        Picasso.get().load(itemEquipo.eturlLogo).into(holder.etUrlLogo)


    }

    override fun getItemCount(): Int {
        return lvEquipos.size
    }


}

