package edu.towson.cosc431.christian.hangman

import android.content.Context
import edu.towson.cosc431.christian.hangman.Interface.IGameRepo
import edu.towson.cosc431.christian.hangman.Interface.IGameTech
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    lateinit var gameHint:IGameTech
    lateinit var game:IGameRepo

    @Test
    fun hintTest(){
        gameHint = GameTech()
        val hint = gameHint.hint("___", "hey")

        assertEquals("h__", hint)
    }
    @Test
    fun hintTestTwo(){
        gameHint = GameTech()
        val hint = gameHint.hint("h__", "hey")

        assertEquals("he_", hint)
    }
    @Test
    fun hintTestThree(){
        gameHint = GameTech()
        val hint = gameHint.hint("h__llo", "hey")

        assertEquals("he_llo", hint)
    }
    @Test
    fun hintTestFour(){
        gameHint = GameTech()
        val hint = gameHint.hint("hey", "hey")

        assertEquals(null, hint)
    }
    @Test
    fun winTest(){
        game = GameRepo()
        val flag = game.winGame("___")
        assertEquals(false, flag)
    }
    @Test
    fun winTestTwo(){
        game = GameRepo()
        val flag = game.winGame("_e_")
        assertEquals(false, flag)
    }
    @Test
    fun winTestThree(){
        game = GameRepo()
        val flag = game.winGame("hey")
        assertEquals(true, flag)
    }
    @Test
    fun inputTest(){
        game = GameRepo()
        val flag = game.inputCount("hey")
        assertEquals(false, flag)
    }
    @Test
    fun inputTestTwo(){
        game = GameRepo()
        val flag = game.inputCount("h")
        assertEquals(true, flag)
    }
    @Test
    fun letterTest(){
        game = GameRepo()
        val flag = game.letterUsed("h", "sku")
        assertEquals(true, flag)
    }
    @Test
    fun letterTestTwo(){
        game = GameRepo()
        val flag = game.letterUsed("k", "sku")
        assertEquals(false, flag)
    }
    @Test
    fun checkWordTest(){
        game = GameRepo()
        val flag = game.checkWord("e", "hellooo")
        assertEquals(true,flag)
    }
    @Test
    fun checkWordTestTwo(){
        game = GameRepo()
        val flag = game.checkWord("p", "hellooo")
        assertEquals(false,flag)
    }
    @Test
    fun checkPlayerChange(){
        game = GameRepo()
        val flag = game.playerChange(8)
        assertEquals("Player One",flag)
    }
    @Test
    fun checkPlayerChangeTwo(){
        game = GameRepo()
        val flag = game.playerChange(13)
        assertEquals("Player Two",flag)
    }

}
