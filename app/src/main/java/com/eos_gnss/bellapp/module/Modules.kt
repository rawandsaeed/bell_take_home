package com.eos_gnss.bellapp.module

import com.eos_gnss.bellapp.data.CarStore
import com.eos_gnss.bellapp.data.CarStoreImpl
import com.eos_gnss.bellapp.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels =  module {
    viewModel { HomeViewModel(get()) }
}

val repositories = module {
    single<CarStore> { CarStoreImpl(get()) }
}