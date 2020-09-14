package com.example.pokemonapi.ui

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemonapi.data.PokemonResponse
import com.example.pokemonapi.data.Result
import com.example.pokemonapi.repo.Repository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PokemonViewModel @Inject constructor(private val repository: Repository): ViewModel(){
    private val progressObservable = MutableLiveData<Boolean>()
    private val pokemonObservable: MutableLiveData<PokemonResponse> = MutableLiveData()
    private val resultsObservable: MutableLiveData<Result> = MutableLiveData()

    private val errorObservable: MutableLiveData<Boolean> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getPokemon(){
        compositeDisposable.add(
            repository.getPokemon()
                .doOnSubscribe { progressObservable.postValue(true)
                }
                .doOnError { progressObservable.value = false
                    Log.wtf("ViewModel Error", "Its working")
                }
                .subscribe({ pokemon ->
                    pokemonObservable.value = pokemon
                    progressObservable.value = false
                    Log.wtf("ViewModel Success", "Its working")
                }, {errorObservable.value = true})
        )
    }

    fun getResults(){
        compositeDisposable.add(
            repository.getResult()
                .doOnSubscribe { progressObservable.postValue(true)
                }
                .doOnError { progressObservable.value = false
                    Log.wtf("ViewModel Error", "Its working")
                }
                .subscribe({ result ->
                    resultsObservable.value = result
                    progressObservable.value = false
                    Log.wtf("ViewModel Success", "Its working")
                }, {errorObservable.value = true})
        )
    }

    fun getPokemonObservable() = pokemonObservable
    fun getResultsObservable() = resultsObservable
    fun getProgressObservable() = progressObservable
    fun getErrorObservable() = errorObservable

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}