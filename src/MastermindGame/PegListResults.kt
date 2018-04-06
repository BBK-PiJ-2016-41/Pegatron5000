package MastermindGame

/**
 * generates a list of results pegs
 */
class PegListResults(pegList: MutableList<Peg>) : PegListImpl(pegList) {

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