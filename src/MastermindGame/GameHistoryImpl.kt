package MastermindGame

object GameHistoryImpl: GameHistory {
    private var numberOfGuesses = 0

    override fun addGuess() {
        numberOfGuesses++
    }

    override fun getProgress() = numberOfGuesses

    override fun printProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}