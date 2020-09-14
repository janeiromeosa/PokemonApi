package com.example.pokemonapi.data
import com.google.gson.annotations.SerializedName


data class PokemonResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<Result>
)

data class Result(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

class CompareByNames {
    companion object : Comparator<Result>{

        override fun compare(o1: Result, o2: Result): Int {
            return o1.name.compareTo(o2.name)
        }
    }
}
