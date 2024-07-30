package com.example.heatingnotebook.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun insertNote (note: Note)
    suspend fun deleteNote(note: Note)
    fun getAllNoteByJournalId (journalId: Int): Flow<List<Note>>
    fun getNoteById (id: Int): Note
    suspend fun geJournalById (journalId: Int): Journal
    suspend fun insertItem(item:Journal)
}