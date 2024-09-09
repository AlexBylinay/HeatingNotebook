package com.example.heatingnotebook.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.heatingnotebook.main_screen.MainScreen
import com.example.heatingnotebook.note_screens.NewNoteScreen
import com.example.heatingnotebook.note_screens.NoteListScreen
import com.example.heatingnotebook.utils.Routes

@Composable
fun MainNavigationGraph () {

    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Routes.MAIN_SCREEN) {

        composable(Routes.LIST_NOTES+"/{journalId}") {
            NoteListScreen()
        }
        composable(Routes.NEW_NOTE ) {
            NewNoteScreen()
            {
                navController.popBackStack()
            }
        }
        composable(Routes.MAIN_SCREEN) {
            MainScreen(navController)
        }


    }

}