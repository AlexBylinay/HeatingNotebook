package com.example.heatingnotebook.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.heatingnotebook.data.Journal
import com.example.heatingnotebook.data.Note
import com.example.heatingnotebook.list_journala_screen.ListJournalsScreen
import com.example.heatingnotebook.note_screens.NewNoteScreen
import com.example.heatingnotebook.note_screens.NoteListScreen
import com.example.heatingnotebook.see_note_screen.NoteScreen
import com.example.heatingnotebook.utils.Routes

@Composable
fun NavigationGraph(navController: NavHostController, onNavigate:(String) -> Unit) {

    val journals = mutableListOf<Journal>(
         Journal (5,"Батоничкская","89/15"),
        Journal(8,"Горовца 45", "89/15"),
        Journal(8,"Солтыса 11", "89/15"),
        Journal(8,"Хуилкины", "89/15"),
        Journal(8,"Черти", "89/15"),
        Journal(8,"Олег", "89/15"),
        Journal (5,"Батоничкская","89/15"),
        Journal(8,"Горовца 45", "89/15"),
        Journal(8,"Солтыса 11", "89/15"),
        Journal(8,"Хуилкины", "89/15"),
        Journal(8,"Черти", "89/15"),
        Journal(8,"Олег", "89/15"),
    )


    val note = Note (1,  "12.09.2024","11:34","99879.110",
        "0.78", "1.7","56.2", "34:78",
        "99879.110", "0.78", "1.7","46.2",
        "34:78", "10.0", "5.0,"," 2:13",4)

    val note2 = Note (4,  "18.19.2024","15:34","99879.110",
        "0.78", "1.7","56.2", "34:78",
        "99879.110", "0.78", "1.7","56.2",
        "34:78", "10.0", "5.0"," 2:13",3)

    val notes = mutableListOf<Note>(note,note2)

    NavHost(
        navController = navController,
        startDestination = Routes.JOURNALS_LIST
    ) {
        composable(Routes.JOURNALS_LIST) {
            ListJournalsScreen(){ route ->
                onNavigate(route)
            }
        }
        composable(Routes.NEW_JOURNAL){
            NewNoteScreen { -> }
            }
        composable(Routes.ABOUT){
            NoteListScreen(){ route ->
                onNavigate(route)
            }
            }
        composable(Routes.SETTINGS){
            NoteScreen()
            }
    }

}