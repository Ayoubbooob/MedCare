package com.bosseurs.medcare.ui.screens.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.CustomButton
import com.bosseurs.medcare.ui.shared.CustomTextField
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.utils.Screen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.White, modifier = Modifier.wrapContentWidth(align = Alignment.Start))
            {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0XFF090F47)
                    )
                }
            }
        }
    ) {
        Column(modifier = Modifier
            .padding(20.dp),Arrangement.spacedBy(15.dp)
        ){
            Text(
                text= stringResource(R.string.new_compte_txt),
                style = MaterialTheme.typography.h2,
            )
            CustomTextField(
                labelText = R.string.name_field,
                leadingIconId = null ,
                iconDescription =null ,
                keyboardType = KeyboardType.Text,
                trailingIconId = null
            )
            CustomTextField(
                labelText =R.string.mobile_number_field,
                leadingIconId = null ,
                iconDescription =null ,
                keyboardType = KeyboardType.Text,
                trailingIconId = null
            )
            CustomTextField(
                labelText =R.string.mail_field,
            leadingIconId = null ,
            iconDescription =null ,
            keyboardType = KeyboardType.Text,
            trailingIconId = null
            )
            CustomTextField(
            labelText =R.string.pass_field,
            leadingIconId = null ,
            iconDescription =null ,
            keyboardType = KeyboardType.Text,
            trailingIconId = null
        )
            CustomButton(textId = R.string.new_compte_btn,
                onClick = {
                          navController.navigate(Screen.LoginScreen.route)

            }, color = BlueColor, textColor = TextForBlueButtonColor, modifier = Modifier.fillMaxWidth())
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(
                    text = stringResource(id = R.string.login_txt),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption,
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Launch() {
//    MedCareTheme {
//        SignUpScreen()
//    }
//}
