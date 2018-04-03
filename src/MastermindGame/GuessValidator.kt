package MastermindGame

class GuessValidator(private val numPegs: Int) {
    fun checkGuess(pegList: PegListGuessMock): Boolean {
        return pegList.pegList.fold(0){sum, pegs ->
            sum + if(coloursContains(pegs.colour)) 1 else 0} == numPegs
    }

    private fun coloursContains(colour: String): Boolean {
        ColoursMock.values().forEach{value -> if (value.name.equals(colour)) return true}
        return false
    }

}