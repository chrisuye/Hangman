package edu.towson.cosc431.christian.hangman

import edu.towson.cosc431.christian.hangman.Interface.IGameTech

class GameTech :IGameTech{

    override fun hint(wordView: String, word: String): String? {

        val wordviewarray = wordView.toCharArray()
        val wordarray = word.toCharArray()
        var i = 0


        while(i < wordviewarray.size){
            if (wordviewarray[i] == '_'){

                wordviewarray.set(i,wordarray[i])
                var wordV = ""

                for (j in wordviewarray){
                    wordV = wordV + j.toString()
                }


                return wordV
            }
            i++
        }
        return null
    }

}