package com.benjaminledet.pokedex.ui.pokemon.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.benjaminledet.pokedex.data.model.PokemonDetail
import com.benjaminledet.pokedex.data.model.Stat
import com.benjaminledet.pokedex.data.repository.PokemonRepository
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class PokemonDetailViewModel(application: Application): AndroidViewModel(application), KoinComponent {

    private val pokemonRepository by inject<PokemonRepository>()

    val pokemonId = MutableLiveData<Int>()

    val pokemon = pokemonId.switchMap { id -> pokemonRepository.getPokemonObservable(id) }

    val moves = pokemon.switchMap { pokemon ->
        pokemonRepository.getMovesobservable(pokemon?.detail?.moves ?: listOf())
    }

    val stats = pokemon.switchMap { pokemon ->
        pokemonRepository.getStatsobservable(pokemon?.detail?.stats ?: listOf())
    }

    val refreshState = pokemonId.switchMap { id -> pokemonRepository.refreshPokemon(viewModelScope, id) }

}