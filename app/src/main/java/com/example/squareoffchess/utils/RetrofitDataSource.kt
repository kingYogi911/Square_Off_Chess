package com.example.squareoffchess.utils

import com.example.squareoffchess.data.apiModel.CardsResponse
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitDataSource {
    @GET("config.json")
    suspend fun getCardsData(): Response<CardsResponse>
}