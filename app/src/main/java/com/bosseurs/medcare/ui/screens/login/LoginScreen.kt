package com.bosseurs.medcare.ui.screens.login

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.httpRequest.Patient
import com.bosseurs.medcare.ui.httpRequest.RetrofitAPI
import com.bosseurs.medcare.ui.shared.CustomButton
import com.bosseurs.medcare.ui.shared.CustomTextField
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.utils.Screen
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    navController: NavController,
){
    var ppr by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    val ctx = LocalContext.current
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
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            ,Arrangement.spacedBy(15.dp),
        ) {
            Text(
                text= stringResource(R.string.login_welcome),
                style = MaterialTheme.typography.h2,
            )
            CustomTextField(
                labelText = R.string.ppr_field,
                leadingIconId = R.drawable.person_icon ,
                iconDescription ="Person Icon" ,
                keyboardType = KeyboardType.Text,
                trailingIconId = null,
                value = ppr,
                onValueChange = {ppr = it}
            )
            CustomTextField(
                labelText = R.string.password,
                leadingIconId = R.drawable.password_icon ,
                iconDescription = "Password Icon" ,
                keyboardType = KeyboardType.Password ,
                trailingIconId = null,
                value = password,
                onValueChange = {password=it}
            )
//
            CustomButton(textId = R.string.connexion_btn,
                onClick = {
                    //for bruce and oumar comment this and work with the Comment line 100
//                     postLoginRetrofit(
//                         ctx,cin.text,password.text,navController
//                     )
// //                    navController.navigate(Screen.HomeScreen.passArgs(true, "Oumar"))

                          //},
//                    postLoginRetrofit(
//                        ctx,cin.text,password.text,navController
//                    )
                    navController.navigate(Screen.HomeScreen.passArgs(true, "Oumar"))
                },
                color = BlueColor,
                textColor = TextForBlueButtonColor,
                modifier = Modifier.fillMaxWidth()
            );
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                ClickableText(
                    text = AnnotatedString(stringResource(id = R.string.sign_up_txt)),
                    onClick = { /* your click action here */
                        navController.navigate(Screen.SignUpScreen.route)
                    },
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W300,                  /* This is for description text */
                        fontSize = 16.sp,
                        color = Color(0XFFc0c2d0)
                    )
                )
            }
        }

    }
}

fun postLoginRetrofit(
    ctx: Context,
    ppr: String,
    password: String,
    navController: NavController
) {
    val url = "http://192.168.1.12:8000/api/"
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(RetrofitAPI::class.java)
    val call = service.login(ppr, password)

    call!!.enqueue(object : Callback<Patient?> {
        override fun onResponse(call: Call<Patient?>, response: Response<Patient?>) {
            if (response.isSuccessful) {
                val patient = response.body()
                    navController.navigate(Screen.HomeScreen.passArgs(true,  patient!!.first_name))
            } else {
                // Login failed, show error message
                Toast.makeText(ctx, "Login failed", Toast.LENGTH_SHORT).show()
            }
        }


        override fun onFailure(call: Call<Patient?>, t: Throwable) {
            TODO("Not yet implemented")
            Toast.makeText(ctx, "Network error", Toast.LENGTH_SHORT).show()

        }
    })
}

//private fun NavController.navigate(route: String, : Bundle) {


