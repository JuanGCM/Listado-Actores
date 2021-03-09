package com.example.listadoapp.ui

data class ActoresResponse(
    val page: Int,
    val results: List<Actor>,
    val total_pages: Int,
    val total_results: Int
)