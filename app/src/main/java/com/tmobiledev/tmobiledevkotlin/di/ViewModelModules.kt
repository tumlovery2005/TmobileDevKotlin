package com.tmobiledev.tmobiledevkotlin.di

import com.tmobiledev.tmobiledevkotlin.ui.FirstViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModules = module {
    viewModel { FirstViewModel(get()) }
}