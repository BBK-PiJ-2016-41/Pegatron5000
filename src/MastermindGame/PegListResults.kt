package MastermindGame

/**
 * generates a list of results pegs
 */
class PegListResults(numPegs: Int) : PegListImpl(numPegs) {

    override fun getNewPeg(): Peg {
        return PegImplResult()
    }

}