package MastermindGame

/**
 * generates a list of coloured pegs
 */
class PegListColourMock(pegList: MutableList<Peg>) : PegListImplMock(pegList) {

    override fun validatePegs() {
        for (p in pegList) {
            try {
                if (p.javaClass.typeName == "MastermindGame.PegImplColour") {
                    //if class type equals what is required then do nothing
                }
            } catch (e: IllegalArgumentException) {
                print("peg type must be Colour")
            }
        }
    }

}

