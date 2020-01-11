package com.benjaminledet.pokedex.ui.pokemon.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.benjaminledet.pokedex.R
import com.benjaminledet.pokedex.data.model.Stat
import com.benjaminledet.pokedex.ui.pokemon.detail.PokemonDetailActivity


class PokemonDetailAdapter(private val stats: List<Stat>, val callback: PokemonDetailActivity):

    RecyclerView.Adapter<PokemonDetailAdapter.MyViewHolder>(){

    class MyViewHolder(val v: LinearLayout): RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.statistique, parent, false)
        return MyViewHolder (layout as LinearLayout)
    }

    override fun getItemCount(): Int {
        return this.stats.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val layout = holder.v
        val stat = stats[position]
        println("Stats :" + stat.name)
        layout.findViewById<TextView>(R.id.stat).text = stat.name

    }
}