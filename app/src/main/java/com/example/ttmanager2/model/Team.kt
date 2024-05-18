package com.example.ttmanager2.model


class Team(
    val ID: Int,
    val name: String,
    val faction: String,
    val factionID: String,
    val value: Int,
    val wins: Int,
    val draws: Int,
    val losses: Int
)

val myTeamsList = listOf(
    Team(1, "Naggaroth Pirates", "Dark Elf", "DE", 1520, 11, 2, 2),
    Team(2, "Los Muy-Golpeados", "High Elf", "HE", 1320, 4, 0, 2),
    Team(3, "Mean & Green", "Black Orc", "BO", 1200, 10, 6, 2),
    Team(4, "Hispana Legends", "Necromantic", "NE", 1550, 11, 2, 3),
    Team(5, "Final de Fantasia", "Undead", "UN", 1760, 12, 0, 1),
    Team(6, "Pepinos Cósmicos", "Nurgle", "NU", 1490, 7, 2, 3),
    Team(7, "La tercera primera opción", "Human", "HU", 1370, 7, 0, 3),
)

val totalTeamsList = listOf(
    Team(1, "Naggaroth Pirates", "Dark Elf", "DE", 1520, 11, 2, 2),
    Team(2, "Los Muy-Golpeados", "High Elf", "HE", 1320, 4, 0, 2),
    Team(3, "Mean & Green", "Black Orc", "BO", 1310, 10, 6, 2),
    Team(4, "Hispana Legends", "Necromantic", "NE", 1550, 11, 2, 3),
    Team(5, "Final de Fantasia", "Undead", "UN", 1760, 12, 0, 1),
    Team(6, "Pepinos Cósmicos", "Nurgle", "NU", 1490, 7, 2, 3),
    Team(7, "La tercera primera opción", "Human", "HU", 1370, 7, 0, 3),
    Team(8, "Los principiantes", "High Elf", "HE", 1740, 8, 2, 7), // Vs mis necros
    Team(9, "Atlético Somarda", "Undead", "UN", 1205, 5, 2, 3), // Vs mis humans
    Team(10, "Más panolis no se puede", "Khorne", "KH", 1870, 8, 2, 2),//Vs mis undeads
    Team(11, "Lefos Asscuros", "Dark Elf", "DE", 1420, 9, 4, 0), //Vs mis nurgle
    Team(12, "Perras Cornudas", "Norses", "NO", 1250, 2, 1, 4), //Vs mis High Elfs
    Team(13, "Inserso Kaos", "Chaos", "CH", 1490, 6, 1, 8),//Vs mis BO
    Team(14, "Necronomicon BBC", "Necromantic", "NE", 1500, 5, 3, 7), //Vs mis DE

    )


