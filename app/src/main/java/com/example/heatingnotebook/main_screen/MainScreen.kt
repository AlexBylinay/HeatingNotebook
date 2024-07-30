package com.example.heatingnotebook.main_screen

import android.annotation.SuppressLint

import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.heatingnotebook.R
import com.example.heatingnotebook.navigation.NavigationGraph
import com.example.heatingnotebook.ui.theme.Orange

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNav(navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                }, containerColor = Orange
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.add_icon
                    ),
                    contentDescription = "Add", tint = Color.White
                )

            }
        },
        floatingActionButtonPosition = FabPosition.Center,


        ) {
        NavigationGraph(navController)

    }
}