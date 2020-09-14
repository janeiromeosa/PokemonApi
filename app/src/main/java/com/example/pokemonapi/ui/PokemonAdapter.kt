package com.example.pokemonapi.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapi.R
import com.example.pokemonapi.data.Result

class PokemonAdapter :
    RecyclerView.Adapter<PokemonAdapter.PokeViewHolder>() {

    private val list = mutableListOf<Result>()

    var data: List<Result>
        get() = list.toList()
        set(value) {
            list.clear()
            list.addAll(value)
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokeViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        val stuff: Result = list[position]
        holder.bind(stuff)

    }


    class PokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.tv_name)


        fun bind(list: Result) {
            name.text = list.name
        }
    }


}
