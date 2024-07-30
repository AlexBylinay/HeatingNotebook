package com.example.heatingnotebook.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

interface JournalRepository {

    suspend fun insertItem(item: Journal)
    fun getAllItems(): Flow<List<Journal>>
    suspend fun deleteJournal(item: Journal)
}