package MastermindGame

object GameHistoryImpl: GameHistory {
    private var numberOfGuesses = 0

    fun addGuess() {
        numberOfGuesses++
    }

    fun getProgress() = numberOfGuesses
}