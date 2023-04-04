package com.bosseurs.medcare.ui.screens.appointment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.CustomTopAppBar
import com.bosseurs.medcare.ui.shared.DayShape
import com.bosseurs.medcare.ui.theme.AppointmentBigTextStyle


@Composable
fun AppointmentScreen()
{
    Scaffold(
        topBar = {
            CustomTopAppBar(
                onClick = {},
                title = stringResource(id = R.string.Rendez_vous))
        }
    ) {
        Column(modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
            Arrangement.spacedBy(15.dp),
        ) {
            Text(
                stringResource(id = R.string.Mars),
                style = AppointmentBigTextStyle
            )
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                for(day in getAllDaysName()){
                   //TODO =: fix scrollable row list of days
                }
            }
        }

    }
}