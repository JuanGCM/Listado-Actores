package com.example.listadoapp.ui

import com.example.listadoapp.ui.KnownFor

data class Result(
    val adult: Boolean,
    val id: Int,
    val known_for: List<Actor>,
    val name: String,
    val popularity: Double,
    val profile_path: String
)