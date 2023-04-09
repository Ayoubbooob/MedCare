package com.example.medcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bosseurs.medcare.ui.theme.MedCareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedCareTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(
    name="button" ,
    backgroundColor=0xFF2196F3 ,
    showBackground  =true ,
    group="accueil-elem"
)
@Composable
fun buttonElement(){
    Button(onClick = { /*TODO*/ } , colors = ButtonDefaults.buttonColors(contentColor = Color.Green ) ,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp ,
            pressedElevation = 20.dp ,
            disabledElevation = 0.dp
        )

        ) {

        Text(text="Click Here" , style = TextStyle(
            color = Color.White
        ))
        Text(text="i am oumar" ,
        style= TextStyle(
            color = Color.Black
        ))
    }
}