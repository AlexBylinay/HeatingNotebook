package com.example.heatingnotebook.main_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.heatingnotebook.ui.theme.HardRed
import com.example.heatingnotebook.ui.theme.Orange
import com.example.heatingnotebook.ui.theme.OrangeLight
import com.example.heatingnotebook.ui.theme.Yellow


@Composable
fun BottomNav(navController: NavHostController) {
    val listItems = listOf(
        BottomNavItem.Journals,
        BottomNavItem.AboutItem,
        BottomNavItem.SettingItem
    )

    BottomNavigation(backgroundColor = Orange,
        modifier = Modifier.padding(bottom = 2.dp)) {
        listItems.forEach { item ->

            BottomNavigationItem(
                selected = false, onClick =
                {
                    navController.navigate(item.route)
                }, icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = "icon"
                    )
                },
                label = {
                    Text(text = item.title,
                    style = TextStyle(fontSize = 10.sp),
                    color = HardRed
                    )
                },
                selectedContentColor = OrangeLight,
                unselectedContentColor = Yellow, alwaysShowLabel = false

            )
        }

    }
}