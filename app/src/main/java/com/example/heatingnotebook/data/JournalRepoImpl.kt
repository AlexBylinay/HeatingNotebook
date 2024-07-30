package com.example.heatingnotebook.data

import kotlinx.coroutines.flow.Flow

class JournalRepoImpl(private val dao: JournalDao): JournalRepository {

    override suspend fun insertItem(item: Journal) {
      dao.insertItem(item)
    }
    override fun getAllItems(): Flow<List<Journal>> {
      return dao.getAllItems()
    }
    override suspend fun deleteJournal(item: Journal) {
      dao.deleteJournal(item)
    }
}