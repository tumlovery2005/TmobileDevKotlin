package com.tmobiledev.tmobiledevkotlin.api

import com.tmobiledev.tmobiledevkotlin.model.user.UserStatusModel
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @GET("checkin/user/me")
    suspend fun userMe(): UserStatusModel
}