package com.example.squareoffchess.utils

import com.example.squareoffchess.data.objectModel.Card

class Repository(private val retrofitDataSource: RetrofitDataSource) {
    @Throws(Exception::class)
    suspend fun getCardData():List<Card>{
        try {
          return  retrofitDataSource.getCardsData().body()!!.list
        }catch (e:Exception){
            throw e
        }
    }
}