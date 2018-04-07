package MastermindGame

object GameHistoryImpl: GameHistory {
    private var guessResultMap = mutableMapOf<PegList, List<Colour>>()

    override fun addGuess(guess: PegList, result: List<Colour>) {
        guessResultMap.put(guess, result)
    }

    override fun getProgress() = guessResultMap.size

    override fun printProgress() {
        guessResultMap.forEach { t, u -> println("Guess: $t, Result: $u") }
    }
}