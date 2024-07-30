package com.example.heatingnotebook.data

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [
        Journal::class,
        Note::class,
    ],
    version = 1,
    exportSchema = true
)


abstract class MainDb: RoomDatabase() {
    abstract val journalDao: JournalDao
    abstract val noteDao: NoteDao
}


