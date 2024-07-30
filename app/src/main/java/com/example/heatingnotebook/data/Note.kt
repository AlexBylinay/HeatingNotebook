package com.example.heatingnotebook.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    @PrimaryKey
    val id: Int? = null,
    val data: String,
    val time: String,

    val amountHeat1: Double,
    val amount1: Double,
    val instantFlow1: Double,
    val temperature1: Double,
    val timeWork1: String,

    val amountHeat2: Double,
    val amount2: Double,
    val instantFlow2: Double,
    val temperature2: Double,
    val timeWork2: String,

    val tempHot: Double,
    val tempHotIm: Double,

    val timeWorkWrong: String,

    val journalId: Int

    )
