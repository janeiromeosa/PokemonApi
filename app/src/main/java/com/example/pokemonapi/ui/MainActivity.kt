package com.example.pokemonapi.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonapi.MyApp
import com.example.pokemonapi.R
import com.example.pokemonapi.data.PokemonResponse
import com.example.pokemonapi.di.pokemon.DaggerPokemonComponent
import com.example.pokemonapi.di.pokemon.PokemonModule
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.Observer
import com.example.pokemonapi.data.CompareByNames
import com.example.pokemonapi.data.Result

import java.util.*
import javax.inject.Inject



class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var pokeViewModel: PokemonViewModel
    private lateinit var adapter: PokemonAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerView()

        DaggerPokemonComponent.builder().appComponent((application as MyApp).component())
            .pokemonModule(
                PokemonModule(this)
            ).build().inject(this)

        pokeViewModel.getPokemon()

        pokeViewModel.getPokemonObservable().observe(this, Observer {
            adapter.data = it.results

        })
    }

//        pokeViewModel.getProgressObservable().observe(this, Observer {
//            if (it == true) {
//                pb_loading.visibility = View.VISIBLE
//            } else {
//                pb_loading.visibility = View.GONE
//            }
//        })
//
//        pokeViewModel.getErrorObservable().observe(this, Observer {
//            if (it == true) {
//                error_message_container.visibility = View.VISIBLE
//            } else {
//                error_message_container.visibility = View.GONE
//            }
//        })

//        btnRetry.setOnClickListener {
//            pokeViewModel.getBeers()
//            error_message_container.visibility = View.GONE
//        }
//    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.sort_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mu_sort_names_ascending -> {
                Toast.makeText(
                    applicationContext,
                    "Names sorted in Ascending Order",
                    Toast.LENGTH_LONG
                ).show()
                pokeViewModel.getPokemonObservable().observe(this, Observer {
                    Collections.sort(it.results, CompareByNames)
                    adapter.data = it.results
                })
                true
            }
//            R.id.mu_sort_names_descending -> {
//                Toast.makeText(
//                    applicationContext,
//                    "Names sorted in Descending Order",
//                    Toast.LENGTH_LONG
//                ).show()
//                pokeViewModel.getPokemonObservable().observe(this, Observer {
//                    Collections.sortDescending(it.results, CompareByNames)
//                    adapter.data = it.results
//
//                })
//                true
//            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun setUpRecyclerView() {
        rv_poke_list.layoutManager = LinearLayoutManager(this)
        adapter = PokemonAdapter()
        rv_poke_list.adapter = adapter
    }

    private fun getDependencies() {

    }
}


