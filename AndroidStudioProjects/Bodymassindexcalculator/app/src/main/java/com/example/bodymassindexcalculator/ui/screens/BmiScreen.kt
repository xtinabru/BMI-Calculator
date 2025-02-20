package com.example.bodymassindexcalculator.ui.screens

import BmiViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bodymassindexcalculator.R
import com.example.bodymassindexcalculator.ui.components.InputField
import com.example.bodymassindexcalculator.ui.models.InputFieldData

@Composable
fun BmiScreen(
    modifier: Modifier = Modifier,
    bmiViewModel: BmiViewModel = viewModel() // Colleghio ViewModel
) {
    val heightInput by bmiViewModel.heightInput.collectAsState()
    val weightInput by bmiViewModel.weightInput.collectAsState()
    val bmi by bmiViewModel.bmiResult.collectAsState()
    val isValidInput = bmi != "0.00"

    val inputFields = listOf(
        InputFieldData(heightInput, bmiViewModel::onHeightChange, R.string.height_label, KeyboardType.Number),
        InputFieldData(weightInput, bmiViewModel::onWeightChange, R.string.weight_label, KeyboardType.Number)
    )

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.title_bmi_calculator),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
                    .padding(top = 64.dp, bottom = 40.dp)
            )

            inputFields.forEach { inputField ->
                InputField(
                    value = inputField.value,
                    onValueChange = inputField.onValueChange,
                    label = stringResource(id = inputField.label),
                    keyboardType = inputField.keyboardType,
                    modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)
                )
            }

            Text(
                text = if (isValidInput) {
                    stringResource(id = R.string.bmi_result, bmi)
                } else {
                    stringResource(id = R.string.enter_valid_data)
                },
                color = if (isValidInput) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.error,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(top = 2.dp)
            )
        }
    }
}

