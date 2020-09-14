package com.example.pokemonapi.di.pokemon

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.pokemonapi.repo.Repository
import com.example.pokemonapi.ui.MainActivity
import com.example.pokemonapi.ui.PokemonViewModel
import com.example.pokemonapi.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PokemonModule(private val mainActivity: MainActivity) {

    @Provides
    @PokemonScope
    fun providePokemonViewModelFactory(repository: Repository): ViewModelFactory {
        return ViewModelFactory(repository)
    }

    @Provides
    @PokemonScope
    fun providepokemonViewModel(pokemonViewModelFactory: ViewModelFactory): PokemonViewModel {

        return ViewModelProvider(mainActivity, pokemonViewModelFactory)
            .get(PokemonViewModel::class.java)
    }
}