package com.example.marvelcomics.model.response


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("limit")
    val limit: Int? = null,
    @SerializedName("offset")
    val offset: Int? = null,
    @SerializedName("results")
    val results: List<charactersDto>? = null,
    @SerializedName("total")
    val total: Int? = null
)