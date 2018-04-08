package MastermindGame

import MastermindGame.Colours.Colour

object GameHistoryImpl: GameHistory {
    /**
     * A map to store the guesses and results associated with them
     */
    private var guessResultMap = mutableMapOf<PegList, List<Colour>>()

    /**
     * Takes a guess in the form of a PegList, and result in the form of a List<Colour>
     *     to keep a record of the game progress.
     */
    override fun addGuess(guess: PegList, result: List<Colour>) {
        guessResultMap.put(guess, result)
    }

    /**
     * Returns the total number of guess/result combinations so far
     */
    override fun getProgress() = guessResultMap.size

    /**
     * Prints out the guesses and results made so far
     */
    override fun printProgress() {
        guessResultMap.forEach { t, u -> println("Guess: $t, Result: $u") }
    }

    override fun clearHistory() {
        guessResultMap.clear()
    }
}