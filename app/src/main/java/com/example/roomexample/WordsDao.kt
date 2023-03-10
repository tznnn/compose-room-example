package com.example.roomexample

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsDao {
    @Query("SELECT * FROM words_table")
    fun getAll(): Flow<List<Words>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(words: Words)

    @Delete
    suspend fun delete(words: Words)
}