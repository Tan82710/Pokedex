package com.benjaminledet.pokedex.data.remote.response

import com.google.gson.annotations.SerializedName

data class  CharacteristicResponse (
    @SerializedName("id")
    val id: Int,

    @SerializedName("descriptions")
    val descriptions: String
)