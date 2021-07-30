package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    init {
        Log.d("GameFragment", "GameViewModel created!")
        getNextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    private lateinit var _currentScrambledWord: MutableLiveData<String>
    val currentScrambledWord: LiveData<String>
        get() = _currentScrambledWord

    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score

    private val _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount

    private lateinit var currentWord: String

    private lateinit var wordsList: MutableList<String>

    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        wordsList.clear()
        getNextWord()
    }

    private fun getNextWord() {
        wordsList = mutableListOf()
        _currentScrambledWord = MutableLiveData()
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while (tempWord.toString().equals(currentWord, false)) {
            tempWord.shuffle()
        }
        println(currentWord)
        println(tempWord)
        println("CRASH")
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            println(tempWord)
            _currentScrambledWord.value = tempWord.toString()
            _currentWordCount.value = (_currentWordCount.value)?.inc()
            wordsList.add(currentWord)
        }
    }

    fun nextWord(): Boolean {
        return if (_currentWordCount.value!! < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentWord, true)) {
            _score.value = _score.value?.plus(SCORE_INCREASE)
            return true
        }
        return false
    }
}
