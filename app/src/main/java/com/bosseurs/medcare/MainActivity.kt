package com.bosseurs.medcare

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.bosseurs.medcare.ui.navigation.Navigation
import com.bosseurs.medcare.ui.shared.CustomButton
import com.bosseurs.medcare.ui.shared.CustomTextField
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.MedCareTheme
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.theme.Typography1
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val currentTheme = isSystemInDarkTheme()
            val toggleTheme: () -> Unit = {
                if (currentTheme) setDayTheme() else setDarkTheme()
            }
            MedCareTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Navigation(toggleTheme)
                }
            }
        }
    }



    private fun setDayTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun setDarkTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
}

@Composable
fun Greeting(name: String) {
    Column() {
        CustomButton(textId = R.string.CONTINUE, onClick = {}, color = BlueColor, textColor = TextForBlueButtonColor)
        Text(text = "Tout savoir sur l'obésité", style = Typography1.h1)
        Text(text = "Etiam mollis metus non purus faucibus sollicitudin. Pellentesque sagittis mi. Integer.",
            style = MaterialTheme.typography.caption)
//        CustomTextField(
//            labelText = R.string.username,
//            leadingIconId = R.drawable.person_icon,
//            iconDescription = "Person Icon" ,
//            keyboardType = KeyboardType.Text,
//            trailingIconId = null
//        )

    }
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//
//    Greeting("CONTINUE")
//
//}
