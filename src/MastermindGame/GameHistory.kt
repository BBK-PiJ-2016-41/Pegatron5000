package MastermindGame

import MastermindGame.Colours.Colour

interface GameHistory {
    /**
     * Takes a guess in the form of a PegList, and result in the form of a List<Colour>
     *     to keep a record of the game progress.
     */
    fun addGuess(guess: PegList, result: List<Colour>)

    /**
     * Returns the total number of guess/result combinations so far
     */
    fun getProgress(): Int

    /**
     * Prints out the guesses and results made so far
     */
    fun printProgress()

    fun clearHistory()
}