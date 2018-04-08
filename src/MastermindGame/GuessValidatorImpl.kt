package MastermindGame

class GuessValidatorImpl(private val numPegs: Int): GuessValidator {

    /**
     * Checks that the guess supplied by the player contains valid colours and is the correct length
     */
    override fun checkGuess(pegList: PegList): Boolean {
        return pegList.getPegMap().map{peg -> peg.value}.fold(0){sum, pegs ->
            sum + if(PegFactory.findAvailableColours().contains(pegs.colour)) 1 else 0} == numPegs
    }
}