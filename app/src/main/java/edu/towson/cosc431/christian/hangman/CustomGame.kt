package edu.towson.cosc431.christian.hangman

import android.app.AlertDialog
import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.towson.cosc431.christian.hangman.Interface.IGameRepo
import edu.towson.cosc431.christian.hangman.Interface.IGameTech
import kotlinx.android.synthetic.main.fragment_hangman_game.*
import kotlinx.android.synthetic.main.fragment_hangman_image.*



class CustomGame : AppCompatActivity() {

    lateinit var gamecheck:IGameRepo
    lateinit var gameHint:IGameTech
    private var backPress:Long = 0
    var backtrace = 0
    var wrongcount = 0
    var hintcount = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_game)



        gamecheck = GameRepo()
        gameHint = GameTech()

        val dialogBuilder = AlertDialog.Builder(layoutInflater.context)
        val dialogB = AlertDialog.Builder(layoutInflater.context)
        val diaogBb = AlertDialog.Builder(layoutInflater.context)
        val dialogRestart = AlertDialog.Builder(layoutInflater.context)



        val intent = intent
        val word = intent.getStringExtra("Word")




        println(word)
        var letters : String = ""
        var wordview = ""

        val wordarry = word.toCharArray()

        for (elm in wordarry){
            wordview = wordview + "_"
        }

        //shows the word in this form:  _________
        word_view.text = wordview
        //display a picture of the begining of hangman
        imageView.setImageResource(R.drawable.white)




        try_btn.setOnClickListener {


            val guess = guess_input.text.toString().toLowerCase()
            guess_input.setText("")

            /*
            the following checks the letter that has just been giving by running the following tests.
            1: checks of the input is one letter, if not if notify the user
            2: checks if the letter has already been used, if so we will notify the user
            3: checks if the letter exists in the word in question
            4: if the letter exists we replace each '_' that is the letter in question
            5: if the letter is wrong, we will display the next image for hangman
            6: if the user has complited each letter in the word, we will show that they have won
            7: if the user has used up all 12 tries, we will notify then that they lost
             */
            if (gamecheck.inputCount(guess)){

                if (gamecheck.letterUsed(guess, letters)){
                    letters = letters + guess + ","
                    showtry_view.text = letters

                    if (gamecheck.checkWord(guess, word)){
                        val wordviewarray = wordview.toCharArray()
                        var count = 0

                        for (elm in wordarry){
                            if (guess.equals(elm.toString())){

                                wordviewarray.set(count, elm)
                                wordview = ""

                                for (i in wordviewarray){
                                    wordview = wordview + i.toString()
                                }

                                word_view.text = wordview
                            }
                            count++

                        }

                    }
                    else {
                        wrongcount++
                        Toast.makeText(this, "Wrong letter", Toast.LENGTH_SHORT).show()
                        when(wrongcount){
                            1 -> imageView.setImageResource(R.drawable.one)
                            2 -> imageView.setImageResource(R.drawable.two)
                            3 -> imageView.setImageResource(R.drawable.three)
                            4 -> imageView.setImageResource(R.drawable.four)
                            5 -> imageView.setImageResource(R.drawable.five)
                            6 -> imageView.setImageResource(R.drawable.six)
                            7 -> imageView.setImageResource(R.drawable.seven)
                            8 -> imageView.setImageResource(R.drawable.eight)
                            9 -> imageView.setImageResource(R.drawable.nine)
                            10 -> imageView.setImageResource(R.drawable.ten)
                            11 -> imageView.setImageResource(R.drawable.eleven)
                            12 -> {
                                imageView.setImageResource(R.drawable.twelve)


                                Toast.makeText(this, "GAME OVER!!!!!", Toast.LENGTH_SHORT).show()

                                dialogBuilder.setMessage("GAME OVER, would you like to try again?")

                                    .setCancelable(false)

                                    .setPositiveButton("Try Again", DialogInterface.OnClickListener {
                                            dialog, id ->
                                        backtrace = 0
                                        wrongcount = 0
                                        imageView.setImageResource(R.drawable.one)
                                        wordview = ""
                                        for (elm in wordarry){
                                            wordview = wordview + "_"
                                        }
                                        letters = ""
                                        word_view.text = wordview
                                        showtry_view.text = letters
                                    })

                                    .setNegativeButton("No", DialogInterface.OnClickListener {
                                            dialog, id -> dialog.cancel()
                                        dialogB.setMessage(word)
                                            .setCancelable(false)
                                            .setPositiveButton("Okay", DialogInterface.OnClickListener {
                                                    dialog, which ->
                                                backtrace = 1
                                                onBackPressed()
                                                dialog.cancel()
                                            })

                                        val alerttwo = dialogB.create()
                                        alerttwo.setTitle("The word was")
                                        alerttwo.show()



                                    })


                                val alert = dialogBuilder.create()

                                alert.setTitle("Custom Game")

                                alert.show()


                            }

                        }
                    }

                }
                else{
                    Toast.makeText(this, "Letter already used", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Only One Letter", Toast.LENGTH_SHORT).show()
            }

            if (gamecheck.winGame(wordview)){
                backtrace = 1
                Toast.makeText(this, "WINNER WINNER!!!!!!", Toast.LENGTH_SHORT).show()

                diaogBb.setMessage("WINNER! The word was, " + word)

                    .setCancelable(false)

                    .setPositiveButton("Great", DialogInterface.OnClickListener {
                            dialog, id ->
                        onBackPressed()
                        dialog.cancel()
                    })



                val alert = diaogBb.create()

                alert.setTitle("Custom Game")

                alert.show()
            }



        }

        hint_btn.setOnClickListener {

            /*
            the player is given 3 hints
            every time the user hits hint, we will display the closest '_' in to a letter
            eg: he___ will become hel__
             */
            when(hintcount){
                3 -> {
                    Toast.makeText(this, "No more hints", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val temphint = gameHint.hint(wordview,word)
                    if (temphint != null){
                        wordview = temphint
                        word_view.text = wordview

                        if (gamecheck.winGame(wordview)){
                            backtrace = 1
                            Toast.makeText(this, "WINNER WINNER!!!!!!", Toast.LENGTH_SHORT).show()

                            diaogBb.setMessage("WINNER! The word was, " + word)

                                .setCancelable(false)

                                .setPositiveButton("Great", DialogInterface.OnClickListener {
                                        dialog, id ->
                                    onBackPressed()
                                    dialog.cancel()
                                })



                            val alert = diaogBb.create()

                            alert.setTitle("Custom Game")

                            alert.show()
                        }
                    }

                    hintcount++


                }
            }



        }



        restart_btn.setOnClickListener {

            /*
            this will restart the game and bring everything back to its original state
             */
            dialogRestart.setMessage("Are you sure?")

                .setCancelable(false)

                .setPositiveButton("RESTART", DialogInterface.OnClickListener {
                        dialog, id ->
                    wordview = ""
                    for (elm in wordarry){
                        wordview = wordview + "_"
                    }

                    word_view.text = wordview
                    imageView.setImageResource(R.drawable.white)
                    letters = ""
                    showtry_view.text = letters
                    hintcount = 0
                    backtrace = 0
                    wrongcount = 0
                    guess_input.setText("")

                    dialog.cancel()
                })

                .setNegativeButton("No", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })


            val alert = dialogRestart.create()

            alert.setTitle("Hangman")

            alert.show()
        }





    }

    override fun onBackPressed() {

        /*
        over rides the backpress to make sure that the user wants to exit the game
         */

        val dialogBuilder = AlertDialog.Builder(layoutInflater.context)


        when(backtrace){
            0 -> {
                dialogBuilder.setMessage("Are you sure?")

                    .setCancelable(false)

                    .setPositiveButton("Stay", DialogInterface.OnClickListener {
                            dialog, id -> dialog.cancel()
                    })
                    .setNegativeButton("Quit", DialogInterface.OnClickListener {
                        dialog, id ->
                        backtrace = 1
                        onBackPressed()
                        dialog.cancel()
                    })



                val alert = dialogBuilder.create()

                alert.setTitle("Custom Game")

                alert.show()

            }
            1 -> {
                super.onBackPressed()
                return
            }
        }





        backPress = System.currentTimeMillis()

    }
}
