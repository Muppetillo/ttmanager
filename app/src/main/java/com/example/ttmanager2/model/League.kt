package com.example.ttmanager2.model

class League (
    val ID: Int,
    val name: String,
    val city: String,
    val country: String
)

val leaguesList = listOf(
    League(1, "Skyraiders League S4", "Zaragoza","Spain"),
    League(1, "XXIII LBBAV", "Zaragoza","Spain"),
    League(1, "VIII Liga Odisea ", "Zaragoza","Spain"),
)