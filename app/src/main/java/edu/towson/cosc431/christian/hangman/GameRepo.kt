package edu.towson.cosc431.christian.hangman


import edu.towson.cosc431.christian.hangman.Interface.IGameRepo

class GameRepo:IGameRepo{


    override fun inputCount(input: String): Boolean {
        if(input.length > 1){
            return false
        }
        return true
    }

    override fun letterUsed(input: String, letter: String): Boolean {
        val letterarray = letter.toCharArray()
        for (i in letterarray){
            if(input == i.toString()){
                return false
            }
        }
        return true
    }

    override fun checkWord(input: String, word: String): Boolean {


        val wordarray = word.toCharArray()
        for (i in wordarray){
            if (input == i.toString()){
                return true
            }

        }
        return false
    }

    override fun winGame(worddisplay: String): Boolean {
        val worddisplayarray = worddisplay.toCharArray()

        for (i in worddisplayarray){
            if ("_" == i.toString()){
                return false
            }
        }
        return true
    }

    override fun playerChange(idx: Int): String {
        when (idx % 2){
            0 -> return "Player One"
        }
        return "Player Two"
    }

}