package MastermindGame

import MastermindGame.Colours.Colour

class PegImpl(override val colour: Colour): Peg {

    /**
     * Overrides toString() to use Peg's toString() method
     * @return String : Colour of peg. May be character or full name, depending on peg type.
     */
    override fun toString(): String {
        return colour.toString()
    }
}