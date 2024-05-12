package com.example.ttmanager2.model

import com.example.ttmanager2.R


class Faction(
    val ID: String,
    val name: String,
    val reroll: Int,
    val apothecary: Boolean,
    val tier: Int,
    val image: Int?
)

val factionsList = listOf(
    Faction("AZ", "Amazon", 50, true, 2,null),
    Faction("BR", "Bretonnian", 60, true, 2,null),
    Faction("BO", "Black Orc", 60, true, 2,null),
    Faction("CH", "Chaos", 60, true, 1,null),
    Faction("CD", "Chaos Dwarf", 70, true, 2,null),
    Faction("CR", "Chaos Renegades", 70, true, 2,null),
    Faction("DE", "Dark Elf", 50, true, 3, R.drawable.dark_elf),
    Faction("DW", "Dwarf", 50, true, 2,R.drawable.dwarf),
    Faction("EL", "Elf", 50, true, 3,null),
    Faction("GO", "Goblin", 60, true, 3,null),
    Faction("HA", "Halfling", 60, true, 3,null),
    Faction("HE", "High Elf", 50, true, 3,null),
    Faction("HU", "Human", 50, true, 2, R.drawable.human),
    Faction("KH", "Khemri", 70, false, 2,null),
    Faction("KI", "Kislev", 50, true, 2,null),
    Faction("LI", "Lizardmen", 70, true, 2,null),
    Faction("NE", "Necromantic", 70, false, 2,null),
    Faction("NO", "Norse", 60, true, 2,null),
    Faction("NU", "Nurgle", 70, false, 2,null),
    Faction("OG", "Ogre", 70, true, 2,null),
    Faction("OR", "Orc", 60, true, 1,null),
    Faction("SK", "Skaven", 50, true, 2,null),
    Faction("SL", "Slann", 50, true, 2,null),
    Faction("UN", "Undead", 70, false, 2,null),
    Faction("UW", "Underworld", 70, true, 2,null),
    Faction("VA", "Vampire", 60, true, 2,null),
    Faction("WE", "Wood Elf", 50, true, 3,null)
)


