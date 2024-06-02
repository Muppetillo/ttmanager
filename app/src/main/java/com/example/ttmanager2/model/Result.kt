package com.example.ttmanager2.model


class Result (
    val ID: Int,
    val team1: String,
    val team1Faction: String,
    val team1FactionID: String,
    val team1TD: Int,
    val team1Cas: Int,
    val team2: String,
    val team2Faction: String,
    val team2FactionID: String,
    val team2TD: Int,
    val team2Cas: Int,
    val league: String,
    val round: String,
)

val resultList = listOf(
        Result(1,"Naggaroth Pirates","Dark Elf","DE",2,1,"Necronomicon BBC","Chaos Chosen","CC",1,5,"Sky Raiders League","Octavos de Final"),
        Result(2,"Naggaroth Pirates","Dark Elf","DE",2,0,"La Furiosidad mató al gato","Khorne","KH",0,3,"Sky Raiders League","Ronad 13"),
        Result(3,"Naggaroth Pirates","Dark Elf","DE",0,2,"Altdorf Sentinels","Human","HU",2,2,"Sky Raiders League","Ronad 5"),
        Result(4,"Naggaroth Pirates","Dark Elf","DE",1,5,"Dame la Mano","Chaos renegades","CR",1,4,"Sky Raiders League","Ronad 6"),


    )