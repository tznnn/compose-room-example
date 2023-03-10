package com.example.roomexample

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: WordsRepository
) : ViewModel() {
    /* private var stateWords= MutableStateFlow(emptyList<Words>())
     var state : StateFlow<List<Words>> = stateWords

     */
    var words by mutableStateOf(emptyList<Words>())

    init {
    }

    fun getWords() {
        viewModelScope.launch {
            repository.getWordsFromRom().collect { response ->
                words = response
            }
        }
    }

    fun addBook(words: Words) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addWordsToRoom(words)
        }
    }
}