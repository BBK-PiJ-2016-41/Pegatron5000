package MastermindGame

import MastermindGame.Colours.Colour

interface GuessChecker {
    /**
     * Accepts a new guess into the guess checker for evaluation
     */
    fun setGuess(newGuess: PegList)

    /**
     * Generates the result from the current guess held by the guess checker.
     */
    fun generateResult(): List<Colour>

    fun isCorrect(): Boolean
}