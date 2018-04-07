package MastermindGame

class GuessValidator(private val numPegs: Int) {
    fun checkGuess(pegList: PegList): Boolean {
        return pegList.getPegMap().map{peg -> peg.value}.fold(0){sum, pegs ->
            sum + if(Factory.findAvailableColours().contains(pegs.colour)) 1 else 0} == numPegs
    }
}