package MastermindGame

class PegImplResult(val colour: Colour) : Peg {

    override fun printColour() {
        print(colour.name)
    }
}