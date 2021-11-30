package com.example.marvelcomics.model.response


import com.google.gson.annotations.SerializedName

data class ItemX(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null
)