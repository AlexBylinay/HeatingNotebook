package com.example.heatingnotebook.di

import android.app.Application
import androidx.room.Room
import com.example.heatingnotebook.data.JournalRepoImpl
import com.example.heatingnotebook.data.JournalRepository
import com.example.heatingnotebook.data.MainDb
import com.example.heatingnotebook.data.NoteRepoImpl
import com.example.heatingnotebook.data.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMainDb(app: Application): MainDb {
        return Room.databaseBuilder(app,
            MainDb::class.java,"journal").build()
    }
    @Provides
    @Singleton
    fun provideJournalRepo(db:MainDb):JournalRepository{
        return JournalRepoImpl(db.journalDao)
    }
    @Provides
    @Singleton
    fun provideNoteRepo(db:MainDb):NoteRepository{
        return NoteRepoImpl(db.noteDao)
    }



}