package com.example.pokemonapi.repo

import com.example.pokemonapi.data.PokemonResponse
import com.example.pokemonapi.data.Result
import io.reactivex.Single

interface RemoteDataSource {
    fun getPokemon(): Single<PokemonResponse>

    fun getResult(): Single<Result>
}