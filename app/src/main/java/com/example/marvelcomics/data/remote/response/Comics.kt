package com.example.marvelcomics.data.remote.response


import com.google.gson.annotations.SerializedName

data class Comics(
    @SerializedName("available")
    val available: Int? = null,
    @SerializedName("collectionURI")
    val collectionURI: String? = null,
    @SerializedName("items")
    val items: List<Item>? = null,
    @SerializedName("returned")
    val returned: Int? = null
)