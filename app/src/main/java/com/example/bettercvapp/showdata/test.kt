package com.example.bettercvapp.showdata

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun DataScreen(
    dataViewModel: DataViewModel = viewModel()
){
  val getData = dataViewModel.state.value
    val getData2 = dataViewModel.state1.value
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "PROFIL")
        Text(text = getData.firstname)
        Text(text = getData.lastname)
        Text(text = getData.borndate)
        Text(text = getData.bornat)
        Text(text = getData.maritalstatus)
        Text(text = getData.drivinglicence)
        Divider(Modifier.fillMaxWidth(1f))
        Text(text = "EXPERIENCE")
        Text(text = getData2.organisation)
        Text(text = getData2.function)
        Text(text = getData2.status)
        Text(text = getData2.startDate)
        Text(text = getData2.endDate)
    }
}