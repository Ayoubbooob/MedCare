package com.bosseurs.medcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bosseurs.medcare.ui.shared.CustomButton
import com.bosseurs.medcare.ui.theme.BlueButton
import com.bosseurs.medcare.ui.theme.MedCareTheme
import com.bosseurs.medcare.ui.theme.TextForBlueButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedCareTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("CONTINUE")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column() {
        CustomButton(text = "$name", onClick = {}, color = BlueButton, textColor = TextForBlueButton)
        Text(text = "Tout savoir sur l'obésité", style = MaterialTheme.typography.h1)
        Text(text = "Etiam mollis metus non purus faucibus sollicitudin. Pellentesque sagittis mi. Integer.",
            style = MaterialTheme.typography.caption)

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

        Greeting("CONTINUE")

}