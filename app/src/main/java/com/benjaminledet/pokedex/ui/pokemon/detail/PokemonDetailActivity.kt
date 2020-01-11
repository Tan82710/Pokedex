package com.benjaminledet.pokedex.ui.pokemon.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.benjaminledet.pokedex.R
import com.benjaminledet.pokedex.data.repository.utils.Status
import com.benjaminledet.pokedex.ui.pokemon.detail.adapter.PokemonAdapterMove
import com.benjaminledet.pokedex.ui.pokemon.detail.adapter.PokemonDetailAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pokemon_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonDetailActivity: AppCompatActivity() {

    private val viewModel by viewModel<PokemonDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel.pokemonId.postValue(intent.getIntExtra("pokemonId", 0))

        viewModel.refreshState.observe(this, Observer { refreshState ->
            progressBar.isVisible = refreshState.status == Status.RUNNING
            content.isVisible = refreshState.status != Status.RUNNING
        })

        viewModel.pokemon.observe(this, Observer { pokemon ->
            title = pokemon?.name
            weight.text = getString(R.string.pokemon_weight, pokemon?.detail?.weight.toString())
            height.text = getString(R.string.pokemon_height, pokemon?.detail?.height.toString())

            type.text = pokemon?.detail?.types.toString()

            /*val randMoves = List(4) { Random.nextInt(moves.id) }
            val attak = pokemon?.detail?.moves
            println("RandomID :" + randMoves)
            println("Attaques :"+ attak)

            moves.text = pokemon?.detail?.moves.toString()
            */


            Picasso.get().load(pokemon?.iconUrl).into(icon)
        })

        val recyclerMove = findViewById<RecyclerView>(R.id.recyViewMoves)

        viewModel.moves.observe(this, Observer { moves ->
            recyclerMove.adapter = PokemonAdapterMove(moves, this)
            recyclerMove.layoutManager = GridLayoutManager(this, 2)
        })

        val recycler = findViewById<RecyclerView>(R.id.recyView)

        viewModel.stats.observe(this, Observer{ stats ->
            recycler.adapter = PokemonDetailAdapter(stats, this)
            recycler.layoutManager = LinearLayoutManager(this)
        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> true
    }

}