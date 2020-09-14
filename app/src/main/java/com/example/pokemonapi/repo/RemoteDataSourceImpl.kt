package com.example.pokemonapi.repo

import com.example.pokemonapi.data.PokemonResponse
import com.example.pokemonapi.data.Result
import com.example.pokemonapi.net.PokemonService
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val pokemonService: PokemonService): RemoteDataSource {
    override fun getPokemon(): Single<PokemonResponse> {
        return pokemonService.getPokemon()
    }

    override fun getResult(): Single<Result> {
        return pokemonService.getResult()
    }
}