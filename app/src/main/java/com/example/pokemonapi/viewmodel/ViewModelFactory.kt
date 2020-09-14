package com.example.pokemonapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokemonapi.repo.Repository
import com.example.pokemonapi.ui.PokemonViewModel
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory(private val repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PokemonViewModel(repository) as T
    }
}