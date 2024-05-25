package com.example.ttmanager2.model


class Match (
    val ID: Int,
    val team1: String,
    val team1Faction: String,
    val team2: String,
    val team2Faction: String,
    val place: String,
    val schedule: String,
    val league: String,
    val round: String,
)

val matchList = listOf(
    Match(1, "Naggaroth Pirates","Dark Elf","Buitres de Hochland","Human","Sky Raiders Club", "02/06/24","Sky Raiders League S3", "Cuartos de final"),
    Match(1, "La primera tercera opción","Human","Los Chupacuellos de Bilbilitania","Vampire","Sky Raiders Club", "04/06/24","XXII LBBAV", "Cuartos de final")
    )