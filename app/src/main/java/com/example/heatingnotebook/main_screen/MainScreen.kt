package com.example.heatingnotebook.main_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.heatingnotebook.R
import com.example.heatingnotebook.dialog.MainDialog
import com.example.heatingnotebook.list_journala_screen.ListJournalViewModel
import com.example.heatingnotebook.navigation.NavigationGraph
import com.example.heatingnotebook.ui.theme.Orange
import com.example.heatingnotebook.ui.theme.RedBlack

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    mainNavController: NavHostController,
    viewModel: MainScreenViewModel = hiltViewModel()) {

    val modifierText = Modifier.padding(
        start = 10.dp, end = 10.dp)

    val textStyle =
        TextStyle(fontSize = 22.sp,color = RedBlack)

    val lable = "Сoздать новый журнал "
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNav(navController)
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(MainScreenEvent.OnShowEditDialog)
                }, containerColor = Orange
            ) {

                Text(
                    text = lable,
                    modifierText,
                    style = textStyle
                )


              //  Icon(
             //       painter = painterResource(
             //           id = R.drawable.add_icon
             //       ),
           //         contentDescription = "Add", tint = Color.White
           //     )

            }
        },
        floatingActionButtonPosition = FabPosition.Center

        )
    {
        NavigationGraph(navController) {route ->
            mainNavController.navigate(route)
        }
        MainDialog(viewModel)

    }
}