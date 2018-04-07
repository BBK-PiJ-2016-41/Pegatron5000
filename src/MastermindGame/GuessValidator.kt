package MastermindGame

interface GuessValidator {
    /**
     * Checks that the guess supplied by the player contains valid colours and is the correct length
     */
    fun checkGuess(pegList: PegList): Boolean
}