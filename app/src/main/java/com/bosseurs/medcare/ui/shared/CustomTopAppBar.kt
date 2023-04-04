package com.bosseurs.medcare.ui.shared

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.theme.AppBarTextStyle
import com.bosseurs.medcare.ui.theme.LeadingIconColor


@Composable
fun CustomTopAppBar(
    title : String = "",
    onClick : () -> Unit,
    actions: @Composable RowScope.() -> Unit = {}
) {

    TopAppBar(
        backgroundColor = Color.Transparent,
        title = {
            Text(text = title, style = AppBarTextStyle)
        },
        navigationIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = LeadingIconColor,
                    contentDescription = "Go Back")
            }
        },
        actions = actions
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TopAppBarPreview(){
    CustomTopAppBar(
        title = stringResource(id = R.string.Rendez_vous),
        onClick = {}
        )
}

