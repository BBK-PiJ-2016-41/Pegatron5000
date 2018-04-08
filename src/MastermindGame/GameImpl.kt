package MastermindGame

import MastermindGame.Colours.Colour

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
            print("How many pegs do you want? ")
            numPegs = readLine()!!.toInt() // requires validation for non-numeric
            println("The available colours are: " + printAvailableColours())
            println("Generating secret code....")
            val secretCode = PegFactory.generateSequence(numPegs)
            secretCodePegs = PegFactory.makePegs(secretCode)
            validator = GuessValidatorImpl(numPegs)
            displayTheCode(showCode, secretCode)
            val guessCheck = GuessCheckerImpl(secretCodePegs)
            var gameFinished = false

            while (GameHistoryImpl.getProgress() <= turns && !gameFinished) {

                println("You have ${turns - GameHistoryImpl.getProgress()} guesses left\n")
                println("What is your next guess?\nType in the characters for your guess and press enter.")
                println("Enter guess: ")
                var userGuess = readLine()!!.toUpperCase()
                var guessPegList = PegFactory.makePegs(PegFactory.interpretUserInput(userGuess))
                displayTheCode(showCode, secretCode)
                while (!validator.checkGuess(guessPegList)) {
                    println("Invalid guess, try again")
                    userGuess = readLine()!!.toUpperCase()
                    guessPegList = PegFactory.makePegs(PegFactory.interpretUserInput(userGuess))
                }

                guessCheck.setGuess(guessPegList)
                val result = guessCheck.generateResult()
                GameHistoryImpl.addGuess(guessPegList, result)
                GameHistoryImpl.printProgress()

                if (guessCheck.isCorrect()) {
                    println("You solved the puzzle! Good job")
                    gameFinished = true
                    newGame = playAnotherGame()
                } else {
                    if (turns - GameHistoryImpl.getProgress() == 0) {
                        println("You did not solve the puzzle. Too bad.")
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
        The code consists of 4 colored pegs.
        The pegs may be one of six colors: blue, green , orange, purple, red, or yellow.
        A color may appear more than once in the code.

        You try to guess what colored pegs are in the code and what order they are in
        After making a guess the result will be displayed.
        A result consists of a black peg for each peg you have exactly correct (color and position) in your guess.
        For each peg in the guess that is the correct color, but is out of position, you get a white peg.

        Only the first letter of the color is displayed. q1_2.B for Blue, R for Red, and so forth.
        When entering guesses you only need to enter the first character of the color as a capital letter.

        You have 12 to guess the answer or you lose the game.\n
        """)
    }

    private fun displayTheCode(displayCode: Boolean, code: ArrayList<Colour>) {
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