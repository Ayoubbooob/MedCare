@file:OptIn(ExperimentalFoundationApi::class)
package com.bosseurs.medcare.ui.screens.appointment
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.httpRequest.AppointmentRequest
import com.bosseurs.medcare.ui.httpRequest.Patient
import com.bosseurs.medcare.ui.httpRequest.RetrofitAPI
import com.bosseurs.medcare.ui.screens.main.HomeViewModel
import com.bosseurs.medcare.ui.shared.CustomButton
import com.bosseurs.medcare.ui.shared.CustomTopAppBar
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.theme.TextForWhiteButtonColor
import com.bosseurs.medcare.ui.utils.Screen
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppointmentScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    isUserConnected: Boolean = false,
    appointmentViewModel: AppointmentViewModel= viewModel(),
    patientID: String = "" // Add the patientID parameter
)
{
    val ctx = LocalContext.current
    appointmentViewModel.updateAppointmentDetails(isUserConnected,patientID)
    val appointmentUiState by appointmentViewModel.uiState.collectAsState()
            Column(modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            CustomTopAppBar(
                onClick = {},
                title = stringResource(id = R.string.Rendez_vous)
//            title = appointmentUiState.patientID
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
                onClick = {
                    postRequestRetrofit(
                            ctx,appointmentUiState.patientID,navController
                        )
                },
                color = BlueColor,
                textColor = TextForBlueButtonColor)
        }


}

fun postRequestRetrofit(ctx: Context, patientID: String, navController: NavController)
{
    val url = "http://192.168.1.12:8000/api/appointment/"
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
    val dataModel = AppointmentRequest(patientID)
    // calling a method to create an update and passing our model class.
    val call: Call<AppointmentRequest?>? = retrofitAPI.request(dataModel)
    // on below line we are executing our method.
    call!!.enqueue(object : Callback<AppointmentRequest?> {
        override fun onResponse(call: Call<AppointmentRequest?>, response: Response<AppointmentRequest?>) {
            if (response.isSuccessful) {
                Toast.makeText(ctx, "Request Successful", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(ctx, call.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        override fun onFailure(call: Call<AppointmentRequest?>, t: Throwable) {
            // we get error response from API.
            Toast.makeText(ctx, "Network Error", Toast.LENGTH_SHORT).show()
        }
    })
}

