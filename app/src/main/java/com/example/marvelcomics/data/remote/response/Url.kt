package com.example.marvelcomics.data.remote.response


import com.google.gson.annotations.SerializedName

data class Url(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("url")
    val url: String? = null
)