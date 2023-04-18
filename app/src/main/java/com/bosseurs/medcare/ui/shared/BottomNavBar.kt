package com.bosseurs.medcare.ui.shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bosseurs.medcare.ui.utils.BottomNavItem
import com.bosseurs.medcare.ui.utils.Screen

//Exemple d'utilisation
//FooterBarInstance()


@Composable
fun FooterBarInstance(navController: NavController){
    FooterBar(navController=navController,items = listOf(
        BottomNavItem(
            name = "Home" ,
            route = "home_route" ,
            icon = Icons.Default.Home ,
        ) ,
        BottomNavItem(
            name = "NOTIFICATION" ,
            route = "notification_route" ,
            icon = Icons.Default.Notifications ,
        ) ,
        BottomNavItem(
            name = "MORE" ,
            route = "more_route" ,
            icon = Icons.Default.Menu ,
        ) ,
        BottomNavItem(
            name = "OBESITE" ,
            route = "obesite_route" ,
            icon = Icons.Default.Check ,
        ) ,
        BottomNavItem(
            name = "PROFILE" ,
            route = "profile_route" ,
            icon = Icons.Default.Person ,
        )
    ))
}

@Composable
fun FooterBar(items:List<BottomNavItem>, navController: NavController,){
    BottomNavigation(modifier = Modifier.fillMaxWidth() , backgroundColor = Color.White , elevation = 5.dp) {
        items.forEach {item->
            BottomNavigationItem(
                selected = true,
                selectedContentColor = Color.Blue,
                unselectedContentColor = Color.White,
                onClick = {
                    if (item.icon == Icons.Default.AccountBox) {
                        navController.navigate(Screen.ProfileScreen.route)
                    }
                          } ,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if(item.badgeCount>0){
                            BadgedBox(badge = { Text(text = item.badgeCount.toString()) }) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = "this is the image icon fo bottom navbar"
                                )
                            }
                        }else{
                            Icon(
                                imageVector = item.icon,
                                contentDescription = "this is the image icon fo bottom navbar"
                            )
                        }
                    }

                }
            )
        }

    }
}