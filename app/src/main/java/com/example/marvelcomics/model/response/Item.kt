package com.example.marvelcomics.model.response


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null
)