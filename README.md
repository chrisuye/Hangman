Author: Christian, Nhat Nguyen, Ha Tran
Course: Mobile Application Development – Towson University


Hangman is an application for Android based on the classic Hangman game
in which users guess letters in the word that is generated randomly by
the app.

###How to run the Hangman android application###
Android Studio SDK is required to run this app
* Clone Hangman repository here at
https://bitbucket.org/Chrisuye/hangman/src/master/
* Open Android Studio
* New > Project > Android > Android Project from Existing Code
* Select the Hangman app located in the cloned folder in the map
‘Hangman’
* Run the app on your mobile or set up a virtual android device and run
it there.


###App components###
* SQLite Database
* Fragments
* RecyclerView
* Network Access (rest API link: https://www.wordgamedictionary.com/word-
lists/)
* Notification
* Servers/IntentService
* Dialog/Menus


###Features###
* Users can create an account and log in using username and password
* Users get to choose play modes: single player, two players and
customized game
* Menus of difficulties levels for users to choose from: 5 letters, 7
letters and 9 letters word
* Users get to enter their own words in customized game
* Users get to pick different background colors
* Users have 3 hint maximum for each round playing
* Users can access score history for win/loss


###Hangman has several functions###
* It should load the dictionaries with words and pick random word from
the dictionary from the database. The program should pick a random word
with certain numbers of letters upon user’s choice of number for that
word.
* Input letters shouldn’t matter if it is a capital or lowercase letter.
Users can only type in letters and check if the letter isn’t already
guessed.
* Function that checks if the input letter is in the word or not, update
the page and checks if all the letters are guessed.

###Compatibility###
Android Studio 3.5.1 and above