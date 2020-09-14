package com.example.pokemonapi.di.app

import com.example.pokemonapi.net.PokemonService
import com.example.pokemonapi.repo.RemoteDataSource
import com.example.pokemonapi.repo.RemoteDataSourceImpl
import com.example.pokemonapi.repo.Repository
import com.example.pokemonapi.repo.RepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(remoteDataSource: RemoteDataSource): Repository {
        return RepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(pokemonService: PokemonService): RemoteDataSource {
        return RemoteDataSourceImpl(pokemonService)
    }
}