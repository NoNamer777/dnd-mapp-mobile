package com.nonamer777.dndmappmobile.api

import com.nonamer777.dndmappmobile.service.DnD5eApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DnD5eApi {

    companion object {

        private val BASE_URL = "https://www.dnd5eapi.co/api/"

        fun createAPI(): DnD5eApiService {
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            val dnD5eApi = Retrofit.Builder()
                .client(httpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return dnD5eApi.create(DnD5eApiService::class.java)
        }
    }
}
