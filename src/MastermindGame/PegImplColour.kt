package MastermindGame

class PegImplColour(val colour: Colour): Peg {

    override fun printColour() {
        print(colour.letter)
    }
}