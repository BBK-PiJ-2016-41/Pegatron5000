package MastermindGame

class PegImplResult(override val colour: Colour): Peg {

    override fun toString(): String {
        return colour.toString()
    }


}