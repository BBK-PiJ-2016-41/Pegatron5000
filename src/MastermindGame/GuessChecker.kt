package MastermindGame

interface GuessChecker {

    fun setGuess(newGuess: PegList)

    fun generateResult(): List<Colour>
}