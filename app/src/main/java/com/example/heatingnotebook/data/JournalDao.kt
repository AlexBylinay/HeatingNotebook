package com.example.heatingnotebook.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Journal)

    @Delete
    suspend fun deleteItem(item: Journal)

    @Query("DELETE FROM note WHERE journalId = :journalId")
    suspend fun deleteNotes(journalId: Int)

    @Query("SELECT * FROM journal")
    fun getAllItems(): Flow<List<Journal>>

    @Transaction
    suspend fun deleteJournal(item: Journal) {
        deleteNotes(item.id!!)
        deleteItem(item)
    }
}