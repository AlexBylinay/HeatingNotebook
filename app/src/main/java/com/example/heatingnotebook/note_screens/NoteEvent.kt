package com.example.heatingnotebook.note_screens

import com.example.heatingnotebook.data.Note

sealed class NoteEvent {
    data class OnShowDeleteDialog(val note: Note): NoteEvent()
    data class OnShowDEventDialog(val note: Note): NoteEvent()
    data class OnTextChange(val text: String): NoteEvent()
    data class OnItemClick (val route: String): NoteEvent()
    data object OnNoteSave: NoteEvent()

}