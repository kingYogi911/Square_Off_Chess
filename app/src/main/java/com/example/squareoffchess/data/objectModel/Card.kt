package com.example.squareoffchess.data.objectModel

import com.google.gson.annotations.SerializedName

data class Card constructor(
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("img")
    val imgUrl: String? = null
) {
    val year
        get() = slug.split('-').let {
            if (it.isNotEmpty()) it[it.size - 1] else "Unknown"
        }
    val dashCount get() = "${slug.count { it == '-' }}"
}