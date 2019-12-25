package com.benjaminledet.pokedex.data.remote.response

import com.google.gson.annotations.SerializedName

data class ApiResourceResponse(

    @SerializedName("name")
    val name: String?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("description")
    val description: String?

)