package com.example.squareoffchess.data.apiModel

import com.example.squareoffchess.data.objectModel.Card
import com.google.gson.annotations.SerializedName

data class CardsResponse(
    @SerializedName("trns")
    val list: List<Card>
)