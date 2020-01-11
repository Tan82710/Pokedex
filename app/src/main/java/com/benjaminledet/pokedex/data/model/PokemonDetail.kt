package com.benjaminledet.pokedex.data.model

import androidx.room.ColumnInfo

data class PokemonDetail(

    @ColumnInfo(name = WEIGHT)
    val weight: Double,

    @ColumnInfo(name = HEIGHT)
    val height: Double,

    @ColumnInfo(name = TYPES)
    val types: List<String>,

    @ColumnInfo(name = MOVES)
    val moves : List<String>,

    @ColumnInfo(name = STATS)
    val stats : List<String>

    /*@ColumnInfo(name = BASE_STAT)
    val base_stat : Int*/

) {

    companion object {
        const val WEIGHT = "weight"
        const val HEIGHT = "height"
        const val TYPES = "types"
        const val MOVES = "moves"
        const val STATS = "stats"
        //const val BASE_STAT = "base_stat"
    }
}