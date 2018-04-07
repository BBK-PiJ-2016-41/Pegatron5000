package MastermindGame

interface GameHistory {
    fun addGuess()
    fun getProgress(): Int
    fun printProgress()
}