package edu.towson.cosc431.christian.hangman

import edu.towson.cosc431.christian.hangman.Interface.IWord

class WordRepo:IWord{

    private var word:MutableList<Words> = mutableListOf()
    private var wordfive:MutableList<Words> = mutableListOf()
    private var wordseven:MutableList<Words> = mutableListOf()
    private var wordnine:MutableList<Words> = mutableListOf()

    override fun getWord(select: Int): String {
        val j = (0..word.size).random()

        when (select){
            0 -> return wordfive.get(j).word
            1 -> return wordseven.get(j).word
            2 -> return wordnine.get(j).word
        }

        return word.get(j).word
    }

    override fun addWord(words: Words, select:Int) {
        word.add(words)
        when (select){
            0 -> wordfive.add(words)
            1 -> wordseven.add(words)
            2 -> wordnine.add(words)
        }
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clear() {
        word.clear()
        wordfive.clear()
        wordseven.clear()
        wordnine.clear()
    }


}