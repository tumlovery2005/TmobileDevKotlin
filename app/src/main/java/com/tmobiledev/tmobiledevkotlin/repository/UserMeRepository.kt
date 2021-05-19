package com.tmobiledev.tmobiledevkotlin.repository

import com.tmobiledev.tmobiledevkotlin.api.ApiService

class UserMeRepository(private val apiService: ApiService) {
    suspend fun repoGetUserMe() = apiService.userMe()
}