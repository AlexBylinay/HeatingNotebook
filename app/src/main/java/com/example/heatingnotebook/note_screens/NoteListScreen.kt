package com.example.heatingnotebook.note_screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.heatingnotebook.data.Note
import com.example.heatingnotebook.list_journala_screen.JournalCard
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun NoteListScreen(
    viewModel: NoteViewModel = hiltViewModel()
) {



    val note = Note (4,  "12.09.2024","11:34",99879.110,
        0.78, 1.7,56.2, "34:78",
        99879.110, 0.78, 1.7,46.2,
        "34:78", 10.0, 5.0," 2:13",30)

    val note2 = Note (4,  "18.19.2024","15:34",99879.110,
        0.78, 1.7,56.2, "34:78",
        99879.110, 0.78, 1.7,56.2,
        "34:78", 10.0, 5.0," 2:13",30)

    val notes = mutableListOf<Note>(note,note2)



    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(bottom = 110.dp)
    )
    {
        items(notes) { item ->
            NoteListCard(item)
        }
    }

}


