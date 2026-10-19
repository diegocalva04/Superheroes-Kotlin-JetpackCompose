/*
 * Copyright (C) 2023 The Android Open Source Project
 * Licensed under the Apache License, Version 2.0 (see LICENSE).
 */
package com.example.superheroes.model

import com.example.superheroes.R

/** Colección local, en el orden establecido por el codelab. */
object HeroesRepository {
    val heroes = listOf(
        Hero(R.string.hero1, R.string.description1, R.drawable.android_superhero1),
        Hero(R.string.hero2, R.string.description2, R.drawable.android_superhero2),
        Hero(R.string.hero3, R.string.description3, R.drawable.android_superhero3),
        Hero(R.string.hero4, R.string.description4, R.drawable.android_superhero4),
        Hero(R.string.hero5, R.string.description5, R.drawable.android_superhero5),
        Hero(R.string.hero6, R.string.description6, R.drawable.android_superhero6)
    )
}
