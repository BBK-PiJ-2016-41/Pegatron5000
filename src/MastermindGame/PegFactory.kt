package MastermindGame

object PegFactory {
    var listLength: Int = 0

    fun startFactory(listLength: Int) {
        this.listLength = listLength
    }

    fun makeColourPegs(input: MutableList<Colour>): PegList {
        val pegs = mutableListOf<Peg>()

        // Check we've received the right number of pegs
        if (input.size > listLength) {
            print("Incorrect number of pegs!")
        } else {
            input.forEach { pegs.add(PegColour(it)) } // Turn each colour into a peg and add to list
        }
        return PegListColourMock(pegs)
    }

    // TODO - these are so similar, do we need separate functions?
    fun makeResultPegs(input: MutableList<Colour>): PegList {
        val resultPegs = mutableListOf<Peg>()

        // Check we've received the right number of pegs
        if (input.size > listLength) {
            print("Incorrect number of pegs!")
        } else {
            input.forEach { resultPegs.add(PegResult(it)) } // Turn each colour into a peg and add to list
        }
        return PegListResultsMock(resultPegs)


    }
}