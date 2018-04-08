package MastermindGame

/**
 * implementation of PegList
 *
 * @param pegList the pegs to be added to the map
 */
class PegListImpl(val pegList: MutableList<Peg>) : PegList {

    /**
     * map of pegs for use in guesses and results
     */
    private val pegs: MutableMap<Int, Peg> = mutableMapOf()

    /**
     * generates a map of pegs of the required type and size for use by the caller
     */
    init {
        addPegsToList()
    }

    /**
     * validates then adds the pegs to the *pegs* map
     * each peg is assigned a numeric key value for use in interpreting the list of pegs
     */
    private fun addPegsToList() {
        var id = 1
        pegList.map{pegs[id] = it; id++}
    }

    /**
     * returns the *pegs* map
     * @return a map of pegs
     */
    override fun getPegMap(): MutableMap<Int, Peg> = pegs


    /**
     * returns the map of pegs as a string
     * @return a string representing the peg colours
     */
    override fun toString(): String {
        return when (pegList[0].toString()) {
            "White", "Black", "" -> pegList.shuffle().toString()
            else -> pegList.toString()
        }
    }
}