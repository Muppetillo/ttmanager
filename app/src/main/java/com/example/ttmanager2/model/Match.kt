package com.example.ttmanager2.model


class Match (
    val ID: Int,
    val team1: String,
    val team1Faction: String,
    val team1FactionID: String,
    val team2: String,
    val team2Faction: String,
    val team2FactionID: String,
    val place: String,
    val schedule: String,
    val league: String,
    val round: String,
)

val matchList = listOf(
    Match(1, "Naggaroth Pirates","Dark Elf","DE","Buitres de Hochland","Human","HU","Sky Raiders Club", "02/06/24","Sky Raiders League S3", "Cuartos de final"),
    Match(1, "La primera tercera opción","Human","HU","Los Chupacuellos de Bilbilitania","Vampire","VA","Sky Raiders Club", "04/06/24","XXII LBBAV", "Cuartos de final")
    )