package com.example.roomexample

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WordsRepositoryImpl @Inject constructor(
    private val wordsDao: WordsDao
) : WordsRepository {

    override suspend fun getWordsFromRom(): Flow<List<Words>> = wordsDao.getAll()


    override suspend fun addWordsToRoom(words: Words) = wordsDao.insert(words)

    override suspend fun deleteWordsRoom(words: Words) {
        TODO("Not yet implemented")
    }
}