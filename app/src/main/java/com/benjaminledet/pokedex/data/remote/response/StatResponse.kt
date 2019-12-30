package com.benjaminledet.pokedex.data.remote.response

import com.google.gson.annotations.SerializedName

data class  StatResponse (
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("game_index")
    val game_index: Int
)