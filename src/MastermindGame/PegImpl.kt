package MastermindGame

class PegImpl(override val colour: Colour): Peg {

    override fun toString(): String {
        return colour.toString()
    }
}