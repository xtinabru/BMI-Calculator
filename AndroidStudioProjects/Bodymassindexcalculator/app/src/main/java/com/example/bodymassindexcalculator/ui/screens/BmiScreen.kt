package com.example.bodymassindexcalculator.ui.screens

import BmiViewModel
import android.icu.text.DecimalFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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

@Composable
fun BmiScreen(
    modifier: Modifier = Modifier,
    bmiViewModel: BmiViewModel = viewModel() // Colleghio ViewModel
) {
    val heightInput by bmiViewModel.heightInput.collectAsState()
    val weightInput by bmiViewModel.weightInput.collectAsState()
    val bmi by bmiViewModel.bmiResult.collectAsState()
    val isValidInput = bmi != "0.00"

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

            OutlinedTextField(
                value = heightInput,
                onValueChange = bmiViewModel::onHeightChange,
                label = { Text(stringResource(id = R.string.height_label)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)
            )

            OutlinedTextField(
                value = weightInput,
                onValueChange = bmiViewModel::onWeightChange,
                label = { Text(stringResource(id = R.string.weight_label)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)
                    .padding(top = 10.dp, bottom = 16.dp)
            )

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