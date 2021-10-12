package com.example.prelim

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EducService {
    @GET("/api/?count=10")

    fun getCardData():
            Call<List<EducAttributes>>
}