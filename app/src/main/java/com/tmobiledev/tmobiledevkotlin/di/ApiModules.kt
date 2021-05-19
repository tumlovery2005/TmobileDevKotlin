package com.tmobiledev.tmobiledevkotlin.di

import com.tmobiledev.tmobiledevkotlin.api.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val ApiModiles = module {
    single(createdAtStart = false) { get<Retrofit>().create(ApiService::class.java) }
}