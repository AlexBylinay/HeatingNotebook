package com.example.heatingnotebook.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "journal")
data class Journal(
    @PrimaryKey
    val id: Int?= null,
    val name: String,
    val number: String,
)
