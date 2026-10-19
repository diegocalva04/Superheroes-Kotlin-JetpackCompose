/*
 * Copyright (C) 2023 The Android Open Source Project
 * Licensed under the Apache License, Version 2.0 (see LICENSE).
 */
package com.example.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/** Recursos que describen un superhéroe del codelab. */
data class Hero(
    @param:StringRes @field:StringRes val nameRes: Int,
    @param:StringRes @field:StringRes val descriptionRes: Int,
    @param:DrawableRes @field:DrawableRes val imageRes: Int
)
