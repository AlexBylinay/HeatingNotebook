package com.example.heatingnotebook.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote (note: Note)
    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note WHERE journalId = :journalId" )
    fun getAllNoteByJournalId (journalId: Int): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id" )
    suspend fun getNoteById (id: Int): Note

    @Query("SELECT * FROM note")
    fun getAllNote (): Flow<List<Note>>

    @Query("SELECT * FROM journal WHERE id = :journalId" )
    suspend fun getJournalById (journalId: Int): Journal

    @Update
    suspend fun insertItem(item:Journal)
}