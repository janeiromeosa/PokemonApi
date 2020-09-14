package com.example.pokemonapi

import android.app.Application
import com.example.pokemonapi.di.app.AppComponent
import com.example.pokemonapi.di.app.DaggerAppComponent
import com.example.pokemonapi.di.app.NetworkModule
import com.example.pokemonapi.di.app.RepositoryModule

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        component()
    }

    fun component(): AppComponent =
        DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .repositoryModule(RepositoryModule())
            .build()
}