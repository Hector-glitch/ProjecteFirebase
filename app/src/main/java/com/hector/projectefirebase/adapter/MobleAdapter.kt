package com.hector.projectefirebase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hector.projectefirebase.R
import com.hector.projectefirebase.model.Moble
import com.hector.projectefirebase.databinding.ItemMobleBinding

class MobleAdapter(private val moblesList: List<Moble>) :
    RecyclerView.Adapter<MobleAdapter.MobleViewHolder>() {

    class MobleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNom: TextView = view.findViewById(R.id.textViewNom)
        val textViewPreu: TextView = view.findViewById(R.id.textViewPreu)
        val textViewStock: TextView = view.findViewById(R.id.textViewStock)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_moble, parent, false)
        return MobleViewHolder(view)
    }

    override fun onBindViewHolder(holder: MobleViewHolder, position: Int) {
        val moble = moblesList[position]
        holder.textViewNom.text = moble.nom
        holder.textViewPreu.text = "${moble.preu}€"
        holder.textViewStock.text = "Stock: ${moble.stock}"
    }

    override fun getItemCount(): Int = moblesList.size
}
