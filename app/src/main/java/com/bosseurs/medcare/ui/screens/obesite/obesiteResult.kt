package com.bosseurs.medcare.ui.screens.obesite

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.httpRequest.ImcRequest
import com.bosseurs.medcare.ui.httpRequest.RetrofitAPI
import com.bosseurs.medcare.ui.shared.CustomButtonObesite
import com.bosseurs.medcare.ui.shared.shadow
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.utils.Screen
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun ObesiteResult(
    navController: NavController,
    obesiteModel : obesiteModel = viewModel() ,
    isUserConnected : Boolean = false ,
    patientID : String = ""
    //modifier : Modifier
    //navController: NavController = rememberNavController()
){
    val ctx = LocalContext.current
    val obesiteUIState by obesiteModel.uiState.collectAsState()
    var gender : String = ""
    if(obesiteUIState.genre){
        gender = "male"
    }else{
        gender = "female"
    }
    obesiteModel.updateObesiteDetails(isUserConnected,patientID)

    Scaffold(
        //backgroundColor = MaterialTheme.colors.onBackground ,
        topBar = {
            TopAppBar(backgroundColor = Color.White, modifier = Modifier.wrapContentWidth(align = Alignment.Start))
            {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0XFF090F47)
                    )
                }
            }
        },

        floatingActionButton = {
            Row(modifier = Modifier.padding(20.dp) ,  verticalAlignment = Alignment.Bottom) {
                CustomButtonObesite(
                    textId = R.string.valider_imc, onClick = {
                        postImcRetrofit(
                            ctx,obesiteUIState.patientID,obesiteUIState.poids.toString(),obesiteUIState.taille.toString(),gender,navController
                        )
                        //navController.popBackStack(route = Screen.HomeScreen.route, inclusive = false)
                    },
                    color = BlueColor, textColor = TextForBlueButtonColor , CustomWidth = 176  , CustomHeight = 50)
            }
        } ,

    ) {
        //var obesiteModel : obesiteModel = viewModel()
        val obesiteUIState by obesiteModel.uiState.collectAsState()
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Center ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.White)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize(fraction = 0.8f)
                        .shadow(
                            color = MaterialTheme.colors.onSecondary,
                            offsetX = 0.dp,
                            offsetY = 22.dp,
                            blurRadius = 14.dp,
                        )
                        .clip(MaterialTheme.shapes.medium)
                        .background(Color.Blue)
                ) {
                    val result = obesiteUIState.poids.toFloat() /(obesiteUIState.taille.toFloat()*obesiteUIState.taille.toFloat())

                    Column() {
                        val Interpretation = when (result) {
                            in  0.toFloat()..18.5.toFloat() -> stringResource(id = R.string.obesity_maigreure)
                            in  18.6.toFloat()..25.toFloat() -> stringResource(id = R.string.obesity_normal)
                            in  26.toFloat()..30.toFloat() -> stringResource(id = R.string.obesity_surpoid)
                            in  31.toFloat()..40.toFloat() -> stringResource(id = R.string.obesity_modererd)
                            else -> stringResource(id = R.string.obesity_severe)
                        }
                        Text(text = "Votre resultat est ${result}" , color = Color.White , fontSize = 20.sp)
                        Text(text = "${Interpretation}" ,color = Color.White , fontSize = 20.sp)

                    }

                }
            }

        }

    }
}


fun postImcRetrofit(
    ctx: Context,
    patientID: String,
    poids: String,
    taille: String,
    gender: String,
    navController: NavController
) {
    val url = "http://192.168.1.12:8000/api/patient/$patientID/"
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
    val dataModel = ImcRequest(poids,taille,gender)
    // calling a method to create an update and passing our model class.
    val call: Call<ImcRequest?>? = retrofitAPI.imc(dataModel)
    // on below line we are executing our method.
    call!!.enqueue(object : Callback<ImcRequest?> {
        override fun onResponse(call: Call<ImcRequest?>, response: Response<ImcRequest?>) {
            if (response.isSuccessful) {
                Toast.makeText(ctx, "imc added Successfully", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(ctx, "imc request failed", Toast.LENGTH_SHORT).show()
            }
        }
        override fun onFailure(call: Call<ImcRequest?>, t: Throwable) {
            // we get error response from API.
            Toast.makeText(ctx, "Network Error", Toast.LENGTH_SHORT).show()
        }
    })
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ObesiteResultScreenPreview() {
    //ObesiteResult()
}

