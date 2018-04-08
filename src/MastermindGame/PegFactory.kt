package MastermindGame

object PegFactory {
    var listLength: Int = 0

    fun startFactory(listLength: Int) {
        this.listLength = listLength
    }

    fun makePegs(input: MutableList<Colour>): PegList {
        val pegs = mutableListOf<Peg>()

        // Check we've received the right number of pegs
        if (input.size > listLength) {
            print("Incorrect number of pegs!")
        } else {
            input.forEach { pegs.add(PegImpl(it)) } // Turn each colour into a peg and add to list
        }
        return PegListImpl(pegs)
    }

}