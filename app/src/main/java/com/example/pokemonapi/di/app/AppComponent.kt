package com.example.pokemonapi.di.app

import com.example.pokemonapi.MyApp
import com.example.pokemonapi.repo.Repository
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    RepositoryModule::class,
    NetworkModule::class])

interface AppComponent{
    fun inject(myApp: MyApp)

    fun repository(): Repository
}