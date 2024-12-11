package com.example.heatingnotebook.data

import kotlinx.coroutines.flow.Flow

class NoteRepoImpl(private val dao: NoteDao) : NoteRepository {

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }
    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
    override fun getAllNoteByJournalId(journalId: Int): Flow<List<Note>> {
        return dao.getAllNoteByJournalId(journalId)
    }
    override fun getNoteById(id: Int): Note {
        return dao.getNoteById(id)
    }

    override fun getAllNote(): Flow<List<Note>> {
        return dao.getAllNote()
    }

    override suspend fun geJournalById(journalId: Int): Journal {
        return dao.getJournalById(journalId)
    }
    override suspend fun insertItem(item: Journal) {
        dao.insertItem(item)
    }
}

