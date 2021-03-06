package com.benjaminledet.pokedex.ui.pokemon.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.benjaminledet.pokedex.R
import com.benjaminledet.pokedex.data.repository.utils.Status
import com.benjaminledet.pokedex.ui.pokemon.detail.adapter.PokemonDetailAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_pokemon_detail.*
import kotlinx.android.synthetic.main.fragment_pokemon_detail.content
import kotlinx.android.synthetic.main.fragment_pokemon_detail.height
import kotlinx.android.synthetic.main.fragment_pokemon_detail.icon
import kotlinx.android.synthetic.main.fragment_pokemon_detail.progressBar
import kotlinx.android.synthetic.main.fragment_pokemon_detail.weight
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.random.Random

class PokemonDetailFragment: Fragment() {

    private val viewModel by viewModel<PokemonDetailViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.fragment_pokemon_detail, container, false)

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.pokemonId.postValue(arguments?.getInt("pokemonId"))


        viewModel.refreshState.observe(viewLifecycleOwner, Observer { refreshState ->
            progressBar.isVisible = refreshState.status == Status.RUNNING
            content.isVisible = refreshState.status != Status.RUNNING
        })

        viewModel.pokemon.observe(viewLifecycleOwner, Observer { pokemon ->
            activity?.title = pokemon?.name
            weight.text = getString(R.string.pokemon_weight, pokemon?.detail?.weight.toString())
            height.text = getString(R.string.pokemon_height, pokemon?.detail?.height.toString())

            val randMoves = List(4) { Random.nextInt(moves.id) }
            val attak = pokemon?.detail?.moves
            println("RandomID :" + randMoves)
            println("Attaques :"+ attak)

            moves.text = pokemon?.detail?.moves.toString()
            type.text = pokemon?.detail?.types.toString()

            Picasso.get().load(pokemon?.iconUrl).into(icon)

            //stat.text = pokemon?.detail?.stats.toString()
        })




    }
}