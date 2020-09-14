package com.example.pokemonapi.di.pokemon

import com.example.pokemonapi.di.app.AppComponent
import com.example.pokemonapi.ui.MainActivity
import dagger.Component

@PokemonScope
@Component(modules = [PokemonModule::class],dependencies = [AppComponent::class])
interface PokemonComponent {
    fun inject(mainActivity: MainActivity)
}