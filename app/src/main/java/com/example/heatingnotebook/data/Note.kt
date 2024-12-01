package com.example.heatingnotebook.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    @PrimaryKey
    val id: Int? = null,
    val data: String,
    val time: String,

    var amountHeat1: String,
    var amount1: String,
    var instantFlow1: String,
    var temperature1: String,
    var timeWork1: String,

    var amountHeat2: String,
    var amount2: String,
    var instantFlow2: String,
    var temperature2: String,
    var timeWork2: String,

    var tempHot: String,
    var tempHotIm: String,

    var timeWorkWrong: String,

    var journalId: Int

    )
