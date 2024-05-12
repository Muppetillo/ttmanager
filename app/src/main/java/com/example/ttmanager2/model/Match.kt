package com.example.ttmanager2.model


class Match (
    val ID: Int,
    val team1: Int,
    val team1TD: Int,
    val team1Cas: Int,
    val team2: Int,
    val team2TD: Int,
    val team2Cas: Int,
    val place: String,
    val schedule: String,
    val league: String,
    val round: String,
    val isFinished: Boolean
)

val myMatchList = listOf(
    Match(1,1,2,1,14,1,5,"SkyRaiders", "29/04/24", "SkyRaiders League S3", "Octavos de Final",true),
    Match(2,2,1,1,12,2,4,"Odisea", "05/07/22", "I Liga Odisea", "Octavos de Final",true),
    Match(3,3,0,0,13,2,1,"SkyRaiders", "15/01/23", "SkyRaiders League S2", "Ronda 9",true),
    Match(4,4,1,2,8,2,2,"SkyRaiders", "08/05/22", "SkyRaiders League S1", "Cuartos de Final",true),
    Match(5,5,3,2,10,0,2,"Atalaya", "22/05/22", "XX LBBAV", "Semifinal",true),
    Match(6,6,1,1,11,1,0,"Atalaya", "05/03/23", "XXI LBBAV", "Ronda 9",true),
    Match(7,7,2,2,9,0,1,"Atalaya", "01/05/24", "XXII LBBAV", "Octavos de Final",true),

)