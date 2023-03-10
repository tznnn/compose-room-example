package com.example.roomexample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class Words(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "english_words") val englishWords: String?,
    @ColumnInfo(name = "turkish_words") val turkishWords: String?
)
