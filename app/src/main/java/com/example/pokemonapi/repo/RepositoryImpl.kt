package com.example.pokemonapi.repo

import com.example.pokemonapi.data.PokemonResponse
import com.example.pokemonapi.data.Result
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource): Repository{
    override fun getPokemon(): Single<PokemonResponse> {
        return remoteDataSource.getPokemon()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getResult(): Single<Result> {
        return remoteDataSource.getResult()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}