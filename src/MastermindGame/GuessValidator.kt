package MastermindGame

class GuessValidator(val numPegs: Int) {
    fun checkGuess(pegList: PegListGuessMock): Boolean {
        return pegList.pegList.size == numPegs
    }
}