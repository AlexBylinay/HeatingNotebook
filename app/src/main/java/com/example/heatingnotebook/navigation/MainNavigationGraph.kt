package com.example.heatingnotebook.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.heatingnotebook.data.Note
import com.example.heatingnotebook.main_screen.MainScreen
import com.example.heatingnotebook.note_screens.NewNoteScreen
import com.example.heatingnotebook.note_screens.NoteListScreen
import com.example.heatingnotebook.note_screens.NoteScreen
import com.example.heatingnotebook.utils.Routes

@Composable
fun MainNavigationGraph () {

    val note = Note (1,  "12.09.2024","11:34","99879.110",
        "0.78", "1.7","56.2", "34:78",
        "99879.110", "0.78", "1.7","46.2",
        "34:78", "10.0", "5.0,"," 2:13",4)

    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Routes.MAIN_SCREEN) {

        composable(Routes.LIST_NOTES+"/{journalId}") {
            NoteListScreen(){ route ->
                navController.navigate(route)
            }
        }
        composable(Routes.NEW_NOTE ) {
            NewNoteScreen()
            {
               // navController.popBackStack()
            }
        }
        composable(Routes.MAIN_SCREEN) {
            MainScreen(navController)
        }
        composable(Routes.SETTINGS) {
            NoteScreen(note)
        }

    }

}