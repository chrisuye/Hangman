package edu.towson.cosc431.christian.hangman.Interface

interface IGameRepo {
    fun inputCount (input:String):Boolean
    fun letterUsed (input: String, letter:String):Boolean
    fun checkWord (input: String, word:String): Boolean
    fun winGame (worddisplay:String):Boolean
    fun playerChange (idx:Int):String
}