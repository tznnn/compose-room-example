package com.example.roomexample

import kotlinx.coroutines.flow.Flow


interface WordsRepository {

    suspend fun getWordsFromRom(): Flow<List<Words>>

    suspend fun addWordsToRoom(words: Words)

    suspend fun deleteWordsRoom(words: Words)

}