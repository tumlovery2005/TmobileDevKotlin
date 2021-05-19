package com.tmobiledev.tmobiledevkotlin.di

import com.tmobiledev.tmobiledevkotlin.repository.UserMeRepository
import org.koin.dsl.module

val RepositoryModel = module {
    single { UserMeRepository(get()) }
}