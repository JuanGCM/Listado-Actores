package com.example.listadoapp.ui

data class Actor(
    val adult: Boolean,
    val id: Int,
    val known_for: List<Peliculas>,
    val name: String,
    val popularity: Double,
    val profile_path: String
)