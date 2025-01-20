package com.hector.examenhector.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hector.examenhector.databinding.ItemMobleBinding
import com.hector.examenhector.model.Moble

class MobleAdapter (val context: Context, var dataset: List<Moble>, val itemOnClickListener: (Moble) -> Unit)
: RecyclerView.Adapter<MobleAdapter.MobleViewHolder>() {

    inner class MobleViewHolder(private var binding: ItemMobleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(moble: Moble) {
            binding.textViewNom.text = moble.name
            binding.textViewPreu.text = moble.price.toString()

            binding.root.setOnClickListener {
                itemOnClickListener.invoke(moble)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobleViewHolder {
        val itemBinding = ItemMobleBinding.inflate(LayoutInflater.from(context), parent, false)
        return MobleViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: MobleViewHolder, position: Int) {
        val moble = dataset[position]
        holder.bind(moble)
    }
}
