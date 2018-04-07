package MastermindGame

interface GameHistory {
    fun addGuess(guess: PegList, result: List<Colour>)
    fun getProgress(): Int
    fun printProgress()
}