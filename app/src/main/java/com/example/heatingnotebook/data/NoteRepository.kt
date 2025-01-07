package com.example.heatingnotebook.data

import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun insertNote (note: Note)
    suspend fun deleteNote(note: Note)
    fun getAllNoteByJournalId (journalId: Int): Flow<List<Note>>
    suspend fun getNoteById (id: Int): Note
    fun getAllNote (): Flow<List<Note>>
    suspend fun geJournalById (journalId: Int): Journal
    suspend fun insertItem(item:Journal)
}