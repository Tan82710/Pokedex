package com.benjaminledet.pokedex.data.remote.response

import com.google.gson.annotations.SerializedName

data class PokemonResponse(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("sprites")
    val sprites: Map<String, String>,

    @SerializedName("height")
    val height: Double,

    @SerializedName("weight")
    val weight: Double,

    @SerializedName("types")
    val types: List<PokemonTypeResponse>,

    @SerializedName("moves")
    val moves: List<PokemonMoveResponse>,

    @SerializedName("stats")
    val stats: List<PokemonStatResponse>


) {

    companion object {

        const val DEFAULT_SPRITE = "front_default"
    }
}

data class PokemonTypeResponse(

    @SerializedName("slot")
    val slot: Int,

    @SerializedName("type")
    val type: ApiResourceResponse
)

data class PokemonMoveResponse(
    @SerializedName("move")
    val move: ApiResourceResponse
)

data class PokemonStatResponse(

    @SerializedName("base_stat")
    val base_stat: Int,

    @SerializedName("effort")
    val effort: Int,

    @SerializedName("stat")
    val stat: ApiResourceResponse
)