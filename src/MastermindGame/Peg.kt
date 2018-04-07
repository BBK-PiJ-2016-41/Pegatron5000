package MastermindGame

/**
 * Peg interface
 */
open class Peg(var colour: Colour) {

    override fun toString(): String {
        return colour.toString()
    }

}