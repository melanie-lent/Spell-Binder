package com.example.apifinal_5esrd.api

import com.example.apifinal_5esrd.SpellItem
import com.example.apifinal_5esrd.SpellResponse
import retrofit2.Call
import retrofit2.http.GET

interface open5eApi {
    @GET("/spells")
    fun fetchSpells1(): Call<SpellResponse>

    @GET("/spells/?page=2")
    fun fetchSpells2(): Call<SpellResponse>

    @GET("/spells/?page=3")
    fun fetchSpells3(): Call<SpellResponse>

    @GET("/spells/?page=4")
    fun fetchSpells4(): Call<SpellResponse>

    @GET("/spells/?page=5")
    fun fetchSpells5(): Call<SpellResponse>

    @GET("/spells/?page=6")
    fun fetchSpells6(): Call<SpellResponse>

    @GET("/spells/?page=7")
    fun fetchSpells7(): Call<SpellResponse>

    /*@GET("/monsters/")
    fun fetchMonsters(): Call<String>

    @GET("/documents/")
    fun fetchDocuments(): Call<String>

    @GET("/backgrounds/")
    fun fetchBackgrounds(): Call<String>

    @GET("/planes/")
    fun fetchPlanes(): Call<String>

    @GET("/sections/")
    fun fetchSections(): Call<String>

    @GET("/feats/")
    fun fetchFeats(): Call<String>

    @GET("/conditions/")
    fun fetchConditions(): Call<String>

    @GET("/races/")
    fun fetchRaces(): Call<String>

    @GET("/classes/")
    fun fetchClasses(): Call<String>

    @GET("/magicitems/")
    fun fetchMagicItems(): Call<String>

    @GET("/weapons/")
    fun fetchWeapons(): Call<String>
*/
}