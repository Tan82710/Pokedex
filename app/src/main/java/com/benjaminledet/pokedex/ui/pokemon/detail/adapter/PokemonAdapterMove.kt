package com.benjaminledet.pokedex.ui.pokemon.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.benjaminledet.pokedex.R
import com.benjaminledet.pokedex.data.model.Move
import com.benjaminledet.pokedex.ui.pokemon.detail.PokemonDetailActivity

class PokemonAdapterMove (private val moves: List<Move>, val callback: PokemonDetailActivity):
    RecyclerView.Adapter<PokemonDetailAdapter.MyViewHolder>(){

    class MyViewHolder(val v: LinearLayout): RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonDetailAdapter.MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.move, parent, false)
        return PokemonDetailAdapter.MyViewHolder(layout as LinearLayout)
    }

    override fun getItemCount(): Int {
        return this.moves.size
    }

    override fun onBindViewHolder(holder: PokemonDetailAdapter.MyViewHolder, position: Int) {
        val layout = holder.v
        val move = moves[position]
        println("Moves :" + move.name)
        layout.findViewById<TextView>(R.id.moves).text = move.name


    }

}
