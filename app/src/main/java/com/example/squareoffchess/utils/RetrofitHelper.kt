package com.example.squareoffchess.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {
    companion object {
        private var instance: RetrofitDataSource? = null
        fun getServiceInstance(): RetrofitDataSource {
            return if (instance != null) {
                instance!!
            } else {
                Retrofit.Builder()
                    .baseUrl("https://followchess.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(RetrofitDataSource::class.java).also {
                        instance = it
                    }
            }
        }
    }
}