package com.bosseurs.medcare.ui.screens.appointment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.CustomButton
import com.bosseurs.medcare.ui.shared.CustomTopAppBar
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.theme.TextForWhiteButtonColor

@Composable
fun AppointmentScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
)
{


        Column(modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            CustomTopAppBar(
                onClick = {},
                title = stringResource(id = R.string.Rendez_vous)
            )
            val image = painterResource(id = R.drawable.appointment)
            Image(
                painter = image,
                contentDescription = "For appointment request screen",
                modifier = modifier
                    .height(299.dp)
                    .width(412.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
            CustomButton(
                textId = R.string.demande_rdv,
                onClick = { /*TODO*/ },
                color = BlueColor,
                textColor = TextForBlueButtonColor)
        }


}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun AppointmentScreenPreview(){
//    AppointmentScreen()
//}

