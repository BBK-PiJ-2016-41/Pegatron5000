package MastermindGame

import MastermindGame.Colours.Colour

object GameHistoryImpl: GameHistory {
    /**
     * A map to store the guesses and results associated with them
     */
    private var guessResultMap = mutableMapOf<PegList, PegList>()

    override fun addGuess(guess: PegList, result: PegList) {
        guessResultMap.put(guess, result)
    }

    override fun getProgress() = guessResultMap.size

    override fun printProgress() {
        guessResultMap.forEach { t, u -> println("Guess: $t, Result: $u") }
    }

    override fun clearHistory() {
        guessResultMap.clear()
    }
}