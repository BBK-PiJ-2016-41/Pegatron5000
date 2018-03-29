package MastermindGame

object GameHistoryImpl: GameHistory {
    //do the isCreated thing - handle concurrent access as shown in lectures?
    private var isCreated = false
    private var numberOfGuesses = 0

    init {
        if(!isCreated) isCreated = true else throw UnsupportedOperationException("Game History already exists")
    }

    /*synchronized*/ fun addGuess() {
        numberOfGuesses++
    }

    fun getProgress() = numberOfGuesses
}