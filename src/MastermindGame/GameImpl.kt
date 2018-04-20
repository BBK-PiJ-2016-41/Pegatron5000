package MastermindGame

import MastermindGame.Colours.Colour
import java.util.*

class GameImpl(val showCode: Boolean): GameAbstractImpl(showCode) {

    /**
     * stores the reference for whether the game has finished, either because player has
     * run out of turns, or they have guessed the code correctly
     */
    var gameFinished = false

    /**
     * stores the reference for whether a new game should be played after the last one finished
     */
    var newGame = true

    /**
     * sets how many turns the player is allowed to take to guess the code
     */
    val turns = 12

    override fun runGames() {
        var numPegs:Int
        var secretCodePegs: PegList

        while (newGame) {
            gameFinished = false
            GameHistoryImpl.clearHistory()
            displayIntroText()
            numPegs = getNumPegs()
            println("The available colours are " + printAvailableColours())
            secretCodePegs = generateCode(numPegs)
            displayTheCode(showCode, secretCodePegs)
            val guessCheck = GuessCheckerImpl(secretCodePegs)

            while (GameHistoryImpl.getProgress() <= turns && !gameFinished) {
                val guessPegList = getUserGuess(numPegs, secretCodePegs, GuessValidatorImpl(numPegs))
                guessCheck.setGuess(guessPegList)
                updateAndPrintHistory(guessCheck, guessPegList)
                checkGuess(guessCheck)
            }
        }
    }

    /**
     * displays the Mastermind game introductory text
     */
    private fun displayIntroText() {
        print("""
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

How many pegs do you want? """)
    }

    /**
     * gets the number of pegs the game should be played with from the user
     * if the user enters 0 or a non-numeric then they must try again
     */
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

    /**
     * generates the secret code that the user has to guess
     * @param numPegs: the number of pegs required to make the secret code
     * @return the secret code
     */
    private fun generateCode(numPegs: Int) : PegList {
        println("Generating secret code....")
        return PegFactoryImpl.makePegs(PegFactoryImpl.generateSequence(numPegs))
    }

    /**
     * gets the user's guess
     * the guess is validated to ensure it is the correct length and contains the correct colours
     * if the guess is invalid the user must try again
     * @param numPegs: the number of pegs required for the user's guess
     * @param secretCodePegs: the pegs that make up the secret code so they can be displayed if required
     * @param validator: a GuessValidatorImpl object so that the guess can be validated
     * @return the user's guess
     */
    private fun getUserGuess(numPegs: Int, secretCodePegs: PegList, validator: GuessValidatorImpl): PegList {
        println("You have ${turns - GameHistoryImpl.getProgress()} guesses left\n")
        println("What is your next guess?\nType in the characters for your guess and press enter.")
        print("Enter guess: ")
        var valid = false
        var guessPegList = PegFactoryImpl.makePegs(PegFactoryImpl.generateSequence(1))
        while(!valid) {
            try {
                val userGuess = readLine()!!.toUpperCase()
                guessPegList = PegFactoryImpl.makePegs(PegFactoryImpl.interpretUserInput(userGuess, numPegs))
                displayTheCode(showCode, secretCodePegs)
                if (validator.checkGuess(guessPegList)) valid = true
            } catch(e: InputMismatchException) {
                println(e.message)
            }
        }
        return guessPegList
    }

    /**
     * displays the secretCode if required by the game
     * @param displayCode: indicates whether the secret code should be displayed or not
     * @param code: the secret code that will be displayed if displayCode is set to true
     */
    private fun displayTheCode(displayCode: Boolean, code: PegList) {
        if (displayCode) println("The secret code is $code\n")
    }

    /**
     * prints out the available colours to the screen for the user
     * @return a string of colours
     */
    private fun printAvailableColours(): String {
        val colours = PegFactoryImpl.findAvailableColours()
        var listOfColours = ""
        for (colour in colours) {
            listOfColours += colour.toString()
        }
        return listOfColours
    }

    /**
     * updates the game history with the user's guess and results and then prints the progress to the user
     * @param guessCheck: a GuessCheckerImpl object so that the result can be generated from the guess
     * @param guessPegList: the users guess as a list of pegs that needs checking
     */
    private fun updateAndPrintHistory(guessCheck : GuessCheckerImpl, guessPegList: PegList) {
        val result = PegFactoryImpl.makePegs(guessCheck.generateResult() as MutableList<Colour>)
        GameHistoryImpl.addGuess(guessPegList, result)
        GameHistoryImpl.printProgress()
    }

    /**
     * decides whether the game should continue or not based on the user's guess and the number of turns left
     * @param guessCheck: GuessCheckerImpl object which tells the game whether the user's guess is correct or not
     */
    private fun checkGuess(guessCheck: GuessCheckerImpl) {
        if (guessCheck.isCorrect()) {
            println("You solved the puzzle! Good job")
            gameFinished = true
            newGame = playAnotherGame()
        } else {
            if (turns - GameHistoryImpl.getProgress() == 0) {
                println("You did not solve the puzzle. Too bad.")
                gameFinished = true
                newGame = playAnotherGame()
            }
        }
    }

    /**
     * asks the user whether they want to play another game or not
     * hitting Y continues, hitting anything else exits
     * @return: a boolean indicating whether another game should be played or not
     */
    private fun playAnotherGame(): Boolean {
        print("Enter Y for another game or anything else to quit: ")
        val play = readLine()!!.toUpperCase()
        return (play == "Y")
    }

}