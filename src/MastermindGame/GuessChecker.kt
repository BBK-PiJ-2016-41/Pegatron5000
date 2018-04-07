package MastermindGame

interface GuessChecker {

    fun setGuess(newGuess: PegListGuessMock)

    fun generateResult(): PegList
}