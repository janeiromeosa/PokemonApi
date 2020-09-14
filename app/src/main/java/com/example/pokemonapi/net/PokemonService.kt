package com.example.pokemonapi.net

import com.example.pokemonapi.data.PokemonResponse
import com.example.pokemonapi.data.Result
import com.example.pokemonapi.util.POKEMON_ENDPOINT
import io.reactivex.Single
import retrofit2.http.GET

interface PokemonService {
    @GET(POKEMON_ENDPOINT)
    fun getPokemon(): Single<PokemonResponse>
    fun getResult(): Single<Result>
}