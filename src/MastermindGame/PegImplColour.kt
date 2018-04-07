package MastermindGame

class PegImplColour(override val colour: Colour): Peg {

    override fun toString(): String {
        return colour.toString()
    }


}