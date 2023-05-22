package com.bosseurs.medcare.ui.screens.obesite

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.FooterBarInstance
import com.bosseurs.medcare.ui.shared.ImageShadowContainer
import com.bosseurs.medcare.ui.theme.Typography1
import com.bosseurs.medcare.ui.utils.ImageModel
import com.bosseurs.medcare.ui.utils.Screen
import com.bosseurs.medcare.ui.screens.obesite.obesiteModel as obesiteModel1

@Composable
fun ObesiteGenre(
    navController: NavController,
    obesiteModel : obesiteModel1 = viewModel()
    //modifier : Modifier
    //navController: NavController = rememberNavController()
){

    Scaffold(
        //backgroundColor = MaterialTheme.colors.onBackground ,
        bottomBar = {
            FooterBarInstance(navController)
        }
    ) {
        //var obesiteModel : obesiteModel1 = viewModel()
        val context = LocalContext.current
        Row(horizontalArrangement = Arrangement.Center , verticalAlignment = Alignment.Top ,  modifier = Modifier
            .padding(6.dp)) {
            Column() {
                Text(text = stringResource(R.string.genre_select_message), style = Typography1.subtitle1)
            }
            Spacer(modifier = Modifier.padding(6.dp))
            Column() {
                Text(text = stringResource(R.string.gennre_bold), style = Typography1.h1)
            }

        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally ,
                verticalArrangement = Arrangement.Center
        ) {
            //Spacer(
            //modifier = Modifier
            //.weight(0.1f)
            //)
            //Button(
            //onClick = {
                //navController.navigate(Screen.ObesiteGenreScreen.route)
            //},
            //) {
            val Man = painterResource(R.drawable.genre_homme )
            val ManImageModelInstance = ImageModel(
                path = Man ,
                size = 200 ,
                contenteDescription = "Genre Image" ,
            )
            val GenreUIState by obesiteModel.uiState.collectAsState()
            //val context = LocalContext.current
            Text(text = "${GenreUIState.genre}")
            ImageShadowContainer(
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .height(232.dp)
                    .width(297.dp)
                    .size(100.dp)
                    .clickable(onClick = {
                        //obesiteModel.updateGenre(genre = true)
                        //Text(text = "hell")
                        navController.navigate(Screen.obesiteTaille.route)
                    }),
                contente = ManImageModelInstance,
            )
            //Spacer(
            //modifier = Modifier
            //.weight(0.1f)
            //)
            //Button(onClick = { /*TODO*/ }) {

            //}
            val HumanImage = painterResource(R.drawable.genre_femme )
            val HumanImageModelInstance = ImageModel(
                path = HumanImage ,
                size = 200 ,
                contenteDescription = "Genre Image" ,
            )
            ImageShadowContainer(color = MaterialTheme.colors.onPrimary , modifier = Modifier
                .height(232.dp)
                .width(297.dp)
                .size(100.dp)
                .clickable(onClick = fun() {
                    obesiteModel.updateGenre(genre = false)
                    navController.navigate(Screen.obesiteTaille.route)

                }) , contente = HumanImageModelInstance)
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ObesiteGenreScreenPreview() {
    //ObesiteGenre(N)
}