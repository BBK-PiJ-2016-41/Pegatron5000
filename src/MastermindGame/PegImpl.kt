package MastermindGame

import MastermindGame.Colours.Colour

class PegImpl(override val colour: Colour): Peg {

    override fun toString(): String {
        return colour.toString()
    }
}