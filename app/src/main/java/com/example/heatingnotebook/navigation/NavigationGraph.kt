package com.example.heatingnotebook.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.heatingnotebook.about_screen.AboutScreen
import com.example.heatingnotebook.create_journal_screen.CreateJournalScreen
import com.example.heatingnotebook.data.Journal
import com.example.heatingnotebook.data.Note
import com.example.heatingnotebook.list_journala_screen.ListJournalsScreen
import com.example.heatingnotebook.note_screens.NewNoteScreen
import com.example.heatingnotebook.note_screens.NoteListScreen
import com.example.heatingnotebook.note_screens.NoteScreen
import com.example.heatingnotebook.utils.Routes

@Composable
fun NavigationGraph(navController: NavHostController) {

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


    val note = Note (4,  "12.09.2024","11:34",99879.110,
        0.78, 1.7,56.2, "34:78",
        99879.110, 0.78, 1.7,56.2,
        "34:78", 10.0, 10.0," 2:13",30)

    val note2 = Note (4,  "18.19.2024","15:34",99879.110,
        0.78, 1.7,56.2, "34:78",
        99879.110, 0.78, 1.7,56.2,
        "34:78", 10.0, 10.0," 2:13",30)

    val notes = mutableListOf<Note>(note,note2)

    NavHost(
        navController = navController,
        startDestination = Routes.JOURNALS_LIST
    ) {
        composable(Routes.JOURNALS_LIST) {
            ListJournalsScreen(journals)
        }
        composable(Routes.NEW_JOURNAL){
            NewNoteScreen()
            }
        composable(Routes.ABOUT){
            NoteListScreen(list = notes )
            }
        composable(Routes.SETTINGS){
            NoteScreen(note)
            }
    }

}