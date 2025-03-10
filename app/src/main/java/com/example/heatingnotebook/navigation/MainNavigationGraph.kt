package com.example.heatingnotebook.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.heatingnotebook.data.Note
import com.example.heatingnotebook.main_screen.MainScreen
import com.example.heatingnotebook.note_screens.NewNoteScreen
import com.example.heatingnotebook.note_screens.NoteListScreen
import com.example.heatingnotebook.see_note_screen.EditNoteScreen
import com.example.heatingnotebook.see_note_screen.NoteScreen
import com.example.heatingnotebook.utils.Routes

@Composable
fun MainNavigationGraph (modifier: Modifier = Modifier,) {

    val note2 = Note (1,  "12.09.2024","11:34","99879.110",
        "0.78", "1.7","56.2", "34:78",
        "99879.110", "0.78", "1.7","46.2",
        "34:78", "10.0", "5.0,"," 2:13",4)

    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Routes.MAIN_SCREEN) {

        composable(Routes.LIST_NOTES+"/{journalId}") {
            NoteListScreen(modifier){ route ->
                navController.navigate(route)
            }
        }
        composable(Routes.NEW_NOTE+"/{journalId}" ) {
            NewNoteScreen(modifier)
            {
                navController.popBackStack()
            }
        }
        composable(Routes.EDIT_NOTE+"/{noteId}") {
            EditNoteScreen(modifier)
            {
                navController.popBackStack()
            }
        }
        composable(Routes.MAIN_SCREEN) {
            MainScreen(modifier, navController)
        }
        composable(Routes.NOTE+"/{noteId}") {
            NoteScreen( modifier = modifier)
        }

    }

}