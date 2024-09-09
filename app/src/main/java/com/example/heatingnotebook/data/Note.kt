package com.example.heatingnotebook.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    @PrimaryKey
    val id: Int? = null,
    val data: String,
    val time: String,

    val amountHeat1: String,
    val amount1: String,
    val instantFlow1: String,
    val temperature1: String,
    val timeWork1: String,

    val amountHeat2: String,
    val amount2: String,
    val instantFlow2: String,
    val temperature2: String,
    val timeWork2: String,

    val tempHot: String,
    val tempHotIm: String,

    val timeWorkWrong: String,

    val journalId: Int

    )
