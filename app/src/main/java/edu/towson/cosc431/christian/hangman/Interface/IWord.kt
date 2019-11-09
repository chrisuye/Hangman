package edu.towson.cosc431.christian.hangman.Interface

import edu.towson.cosc431.christian.hangman.Words

interface IWord {
    fun getWord(select:Int):String
    fun addWord(words: Words, select: Int)
    fun getCount():Int
    fun clear()
}