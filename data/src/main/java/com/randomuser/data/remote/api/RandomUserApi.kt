package com.randomuser.data.remote.api

import com.randomuser.data.remote.dto.ApiResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserApi {

    @GET("api/")
    suspend fun getRandomUser(
        @Query("gender") gender: String,
        @Query("nat") nationality: String,
        @Query("results") results: Int = 1
    ): ApiResponseDto
}