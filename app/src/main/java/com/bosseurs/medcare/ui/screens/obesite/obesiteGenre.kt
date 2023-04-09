package com.bosseurs.medcare.ui.screens.obesite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.FooterBarInstance
import com.bosseurs.medcare.ui.shared.ImageShadowContainer
import com.bosseurs.medcare.ui.theme.Typography1
import com.bosseurs.medcare.ui.utils.ImageModel

@Composable
fun ObesiteGenre(
    //navController: NavController,
    //modifier : Modifier
){

    Scaffold(
        //backgroundColor = MaterialTheme.colors.onBackground ,
        bottomBar = {
            FooterBarInstance()
        }
    ) {
        Row(horizontalArrangement = Arrangement.Center , verticalAlignment = Alignment.Top ,  modifier = Modifier
            .fillMaxSize()
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
            val Man = painterResource(R.drawable.genre_homme )
            val ManImageModelInstance = ImageModel(
                path = Man ,
                size = 200 ,
                contenteDescription = "Genre Image" ,
            )
            ImageShadowContainer(color = MaterialTheme.colors.onPrimary , modifier = Modifier
                .height(232.dp)
                .width(297.dp)
                .size(100.dp) , contente = ManImageModelInstance)
            //Spacer(
            //modifier = Modifier
            //.weight(0.1f)
            //)
            val HumanImage = painterResource(R.drawable.genre_femme )
            val HumanImageModelInstance = ImageModel(
                path = HumanImage ,
                size = 200 ,
                contenteDescription = "Genre Image" ,
            )
            ImageShadowContainer(color = MaterialTheme.colors.onPrimary , modifier = Modifier
                .height(232.dp)
                .width(297.dp)
                .size(100.dp) , contente = HumanImageModelInstance)
        }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ObesiteGenreScreenPreview() {
    ObesiteGenre()
}