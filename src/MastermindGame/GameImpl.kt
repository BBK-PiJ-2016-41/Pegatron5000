package MastermindGame

import MastermindGame.Colours.Colour
import java.util.*

class GameImpl(val showCode: Boolean): GameAbstractImpl(showCode) {

    override fun runGames() {

        var newGame = true
        var numPegs: Int
        var secretCodePegs: PegList
        val turns = 12
        var validator: GuessValidatorImpl

        while (newGame) {
            GameHistoryImpl.clearHistory()
            displayIntroText()
            print("How many pegs do you want to play with? ")
            numPegs = getNumPegs()
            println("The available colours are " + printAvailableColours())
            println("Generating secret code....")
            val secretCode = PegFactory.generateSequence(numPegs)
            secretCodePegs = PegFactory.makePegs(secretCode)
            validator = GuessValidatorImpl(numPegs)
            displayTheCode(showCode, secretCodePegs)
            val guessCheck = GuessCheckerImpl(secretCodePegs)
            var gameFinished = false

            while (GameHistoryImpl.getProgress() <= turns && !gameFinished) {

                println("You have ${turns - GameHistoryImpl.getProgress()} guesses left\n")
                println("What is your next guess?\nType in the characters for your guess and press enter.")
                print("Enter guess: ")
                val guessPegList = getUserGuess(numPegs, secretCodePegs, validator)
                guessCheck.setGuess(guessPegList)

                val result = PegFactory.makePegs(guessCheck.generateResult() as MutableList<Colour>)
                GameHistoryImpl.addGuess(guessPegList, result)
                GameHistoryImpl.printProgress()

                if (guessCheck.isCorrect()) {
                    println("\nYou solved the puzzle! Good job\n")
                    gameFinished = true
                    newGame = playAnotherGame()
                } else {
                    if (turns - GameHistoryImpl.getProgress() == 0) {
                        println("\nYou did not solve the puzzle. Too bad\n")
                        gameFinished = true
                        newGame = playAnotherGame()
                    } else {
                        continue
                    }
                }
            }
        }
    }

    private fun displayIntroText() {
        println("""
Welcome to Mastermind.

This is a text version of the classic board game Mastermind.
The computer will think of a secret code.
The code consists of 4 coloured pegs.
The pegs may be one of six colours: blue, green, orange, purple, red, or yellow.
A color may appear more than once in the code.

You try to guess what coloured pegs are in the code and what order they are in
After making a guess the result will be displayed.
A result consists of a black peg for each peg you have exactly correct (colour and position) in your guess.
For each peg in the guess that is the correct colour, but is out of position, you get a white peg.

Only the first letter of the colour is displayed. B for Blue, R for Red, and so forth.
When entering guesses you only need to enter the first character of the color as a capital letter.

You have 12 attempts to guess the answer or you lose the game.
        """)
    }

    private fun getNumPegs(): Int {
        var valid = false
        var numPegs = 0
        val message = "Please enter a number greater than 0\nHow many pegs do you want? "
        while (!valid) {
            try {
                numPegs = readLine()!!.toInt()
                if (numPegs > 0) valid = true
                else print(message)
            } catch(e: Exception) {
                print(message)
            }
        }
        return numPegs
    }

    private fun getUserGuess(numPegs: Int, secretCodePegs: PegList, validator: GuessValidatorImpl): PegList {
        var valid = false
        var guessPegList = PegFactory.makePegs(PegFactory.generateSequence(1))
        while(!valid) {
            try {
                val userGuess = readLine()!!.toUpperCase()
                guessPegList = PegFactory.makePegs(PegFactory.interpretUserInput(userGuess, numPegs))
                displayTheCode(showCode, secretCodePegs)
                if (validator.checkGuess(guessPegList)) valid = true
            } catch(e: InputMismatchException) {
                println(e.message)
            }
        }
        return guessPegList
    }


    private fun displayTheCode(displayCode: Boolean, code: PegList) {
        if (displayCode) println("The secret code is $code\n")
    }

    private fun printAvailableColours(): String {
        val colours = PegFactory.findAvailableColours()
        var listOfColours = ""
        for (colour in colours) {
            listOfColours += colour.toString()
        }
        return listOfColours
    }

    private fun playAnotherGame(): Boolean {
        print("Enter Y for another game or anything else to quit: ")
        val play = readLine()!!.toUpperCase()
        return (play == "Y")
    }

}