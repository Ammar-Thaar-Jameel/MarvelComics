package com.example.marvelcomics.model.response


import com.google.gson.annotations.SerializedName

data class ItemXX(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null
)