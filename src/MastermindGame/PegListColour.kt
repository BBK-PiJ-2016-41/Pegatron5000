package MastermindGame

/**
 * generates a list of coloured pegs
 */
class PegListColour(numPegs: Int) : PegListImpl(numPegs) {

    override fun getNewPeg(): Peg {
        return PegImplColour()
    }

}