package com.example.bodymassindexcalculator.ui.models

import androidx.compose.ui.text.input.KeyboardType

data class InputFieldData(
    val value: String,
    val onValueChange: (String) -> Unit,
    val label: Int,
    val keyboardType: KeyboardType
)
