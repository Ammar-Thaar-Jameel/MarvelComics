package com.example.marvelcomics.data.remote.response


import com.google.gson.annotations.SerializedName

data class ItemX(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null
)