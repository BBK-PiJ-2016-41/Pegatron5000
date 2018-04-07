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

    fun makeResultPegs(input: MutableList<Colour>): PegList {
        val pegs = mutableListOf<Peg>()

        // Check we've received the right number of pegs
        if (input.size > listLength) {
            print("Incorrect number of pegs!")
        } else {
            input.forEach { pegs.add(PegResult(it)) } // Turn each colour into a peg and add to list
        }
        return PegListResultsMock(pegs)


    }
}