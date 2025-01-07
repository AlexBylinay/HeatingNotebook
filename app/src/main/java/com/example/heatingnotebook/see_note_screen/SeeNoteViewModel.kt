package com.example.heatingnotebook.see_note_screen

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.heatingnotebook.data.Note
import com.example.heatingnotebook.data.NoteRepository
import com.example.heatingnotebook.dialog.DialogController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeeNoteViewModel @Inject constructor(
    private val repository: NoteRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var note: Note? = null

    var noteId: Int = 5
    var note2 = mutableStateOf(note)

    init {
        noteId = savedStateHandle.get<String>("noteId")?.toInt()!!

        viewModelScope.launch { note2.value = repository.getNoteById(noteId) }
    }


}