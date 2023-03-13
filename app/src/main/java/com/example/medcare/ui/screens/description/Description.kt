package com.example.medcare.ui.screens.description
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.medcare.R
import com.example.medcare.ui.theme.MedCareTheme


@Composable
fun DescriptionMedCare(
    descriptionViewModel: DescriptionViewModel = viewModel()){
    val descriptionUiState by descriptionViewModel.uiState.collectAsState()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)) {
    Spacer(modifier = Modifier
        .weight(0.1f)
        .background(Color.Yellow))
        Column(modifier = Modifier
            .weight(0.4f)
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .fillMaxHeight()
            .wrapContentHeight(align = Alignment.CenterVertically)
            .background(Color.Cyan)){
            Image(painter = painterResource(id = descriptionUiState.image) , contentDescription = null )
        }
        Spacer(modifier = Modifier
            .weight(0.06f)
        )
        Column(modifier = Modifier
            .weight(0.35f)
            .fillMaxSize()
            .padding()
           ,Arrangement.spacedBy(10.dp)
            , horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text= stringResource(id = descriptionUiState.bigText),
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = descriptionUiState.descriptionText),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(25.dp)
                )

        }
        Row(modifier = Modifier
            .weight(0.09f)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
            OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.button_skip))
            }
            Text(text = "...." , fontWeight = FontWeight.Bold)
            OutlinedButton(onClick = {descriptionViewModel.updateDetailsInterface() }) {
                Text(text = stringResource(id = R.string.button_next))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Launch() {
    MedCareTheme {
        DescriptionMedCare()
    }
}
