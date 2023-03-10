package com.example.roomexample

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideBookDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "words_table"
    ).build()

    @Provides
    fun provideBookDao(
        appDatabase: AppDatabase
    ) = appDatabase.wordsDao()

    @Provides
    fun provideBookRepository(
        wordsDao: WordsDao
    ): WordsRepository = WordsRepositoryImpl(wordsDao)
}