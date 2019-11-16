package edu.towson.cosc431.christian.hangman.Interface

interface IGameTech {
    fun hint(wordView:String,word:String):String?
}