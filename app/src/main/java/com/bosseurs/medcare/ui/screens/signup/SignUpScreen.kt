package com.bosseurs.medcare.ui.screens.signup

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
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
import androidx.navigation.NavController
//import coil.decode.EmptyDecoder.result
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.httpRequest.Patient
import com.bosseurs.medcare.ui.httpRequest.RetrofitAPI
import com.bosseurs.medcare.ui.shared.CustomButton
import com.bosseurs.medcare.ui.shared.CustomTextField
import com.bosseurs.medcare.ui.shared.CustomTopAppBar
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
fun SignUpScreen(navController: NavController) {
    val ctx = LocalContext.current
    var first_name by remember { mutableStateOf(TextFieldValue()) }
    var last_name by remember { mutableStateOf(TextFieldValue()) }
    var num by remember { mutableStateOf(TextFieldValue()) }
    var cin by remember { mutableStateOf(TextFieldValue()) }
    var ppr by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        topBar = { CustomTopAppBar(
            onClick = { navController.popBackStack() },
        ) }
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Text(
                text = stringResource(R.string.new_compte_txt),
                style = MaterialTheme.typography.h2,
            )
            CustomTextField(
                labelText = R.string.first_name_field,
                leadingIconId = null,
                iconDescription = null,
                keyboardType = KeyboardType.Text,
                value = first_name,
                onValueChange = { first_name = it },
                trailingIconId = null
            )
            CustomTextField(
                labelText = R.string.last_name_field,
                leadingIconId = null,
                iconDescription = null,
                keyboardType = KeyboardType.Text,
                value = last_name,
                onValueChange = { last_name = it }, trailingIconId = null
            )
            CustomTextField(
                labelText = R.string.mobile_number_field,
                leadingIconId = null,
                iconDescription = null,
                keyboardType = KeyboardType.Phone,
                value = num,
                onValueChange = { num = it }, trailingIconId = null
            )
            CustomTextField(
                labelText = R.string.cin_field,
                leadingIconId = null,
                iconDescription = null,
                keyboardType = KeyboardType.Text,
                value = cin,
                onValueChange = { cin = it }, trailingIconId = null
            )
            CustomTextField(
                    labelText = R.string.ppr_field,
            leadingIconId = null,
            iconDescription = null,
            keyboardType = KeyboardType.Text,
            value = ppr,
            onValueChange = { ppr = it }, trailingIconId = null
            )
            CustomTextField(
                labelText = R.string.pass_field,
                leadingIconId = null,
                iconDescription = null,
                keyboardType = KeyboardType.Password,
                value = password,
                onValueChange = { password = it }, trailingIconId = null
            )
            CustomButton(textId = R.string.new_compte_btn,
                onClick = {
                    postDataUsingRetrofit(
                        ctx,first_name,last_name,num,cin,ppr,password,navController
                    )
                    //navController.navigate(Screen.LoginScreen.route)
                }
                ,
                color = BlueColor,
                textColor = TextForBlueButtonColor,
                modifier = Modifier.fillMaxWidth())
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                ClickableText(
                    text = AnnotatedString(stringResource(id = R.string.login_txt)),
                    onClick = { /* your click action here */
                        navController.navigate(Screen.LoginScreen.route)
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

fun postDataUsingRetrofit(
    ctx: Context,
    firstName: TextFieldValue,
    lastName: TextFieldValue,
    num: TextFieldValue,
    cin: TextFieldValue,
    ppr:TextFieldValue,
    password: TextFieldValue,
    navController: NavController
) {
    val url = "http://192.168.1.12:8000/api/patient/"
    // on below line we are creating a retrofit
    // builder and passing our base url
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        // as we are sending data in json format so
        // we have to add Gson converter factory
        .addConverterFactory(GsonConverterFactory.create())
        // at last we are building our retrofit builder.
        .build()
    // below the line is to create an instance for our retrofit api class.
    val retrofitAPI = retrofit.create(RetrofitAPI::class.java)
    // passing data from our text fields to our model class.
    val dataModel = Patient(firstName.text, lastName.text,cin.text,ppr.text,num.text,password.text)
    // calling a method to create an update and passing our model class.
    val call: Call<Patient?>? = retrofitAPI.register(dataModel)
    // on below line we are executing our method.
    call!!.enqueue(object : Callback<Patient?> {
        override fun onResponse(call: Call<Patient?>, response: Response<Patient?>) {
            // this method is called when we get response from our api.
//            Toast.makeText(ctx, "Data posted to API", Toast.LENGTH_SHORT).show()
            navController.navigate(Screen.LoginScreen.route)
        }

        override fun onFailure(call: Call<Patient?>, t: Throwable) {
            // we get error response from API.
            Toast.makeText(ctx, "Data posted to API"+t.message, Toast.LENGTH_SHORT).show()
        }
    })
}
