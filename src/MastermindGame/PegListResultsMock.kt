package MastermindGame

/**
 * generates a list of results pegs
 */
class PegListResultsMock(pegList: MutableList<Peg>) : PegListImplMock(pegList) {

    override fun validatePegs() {
        for (p in pegList) {
            try {
                if (p.javaClass.typeName == "MastermindGame.PegImplResult") {
                    //if class type equals what is required then do nothing
                }
            } catch (e: IllegalArgumentException) {
                print("peg type must be Result")
            }
        }
    }

}