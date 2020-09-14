package com.example.pokemonapi.viewmodel

import android.location.Address
import android.location.Geocoder
import android.location.Location
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.pokemonapi.repo.Repository
import com.example.pokemonapi.repo.RepositoryImpl
import com.example.pokemonapi.ui.PokemonViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

class ViewModelTest @RunWith(JUnit4::class)
class PrayerTimeViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()
    private lateinit var SUT: PokemonViewModel

    lateinit var repo: Repository

    @Before
    fun setUpTtest() {
        repo = mock<RepositoryImpl>()

        SUT = PokemonViewModel(repo)
    }

    @Test
    fun `get Pokemon results -  should not return null`() {
        //arrange
        whenever(repo.getPokemon()).thenReturn(
            mock()
        )
        //act
        SUT.getPokemon()

        //assert
        assert(SUT.getPokemonObservable().value != null)

    }
}