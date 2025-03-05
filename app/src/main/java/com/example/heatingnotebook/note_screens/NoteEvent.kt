package com.example.heatingnotebook.note_screens

import com.example.heatingnotebook.data.Note
import com.example.heatingnotebook.list_journala_screen.ListJournalEvent

sealed class NoteEvent {
    data class OnShowDeleteDialog(val note: Note): NoteEvent()
    data class OnShowChangeScreen(val note: Note): NoteEvent()
    data class OnTextChange(val text: String): NoteEvent()
    data class OnItemClick (val route: String): NoteEvent()
    data object OnNoteSave: NoteEvent()

}