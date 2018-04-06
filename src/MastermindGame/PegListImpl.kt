package MastermindGame

/**
 * implementation of PegList that provides an abstraction for creating a set of different types of pegs
 *
 * @param pegList the pegs to be added to the map
 */
abstract class PegListImpl(val pegList: MutableList<Peg>) : PegList {

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
     * adds the pegs to the *pegs* map
     * each peg is assigned a numeric key value for use in interpreting the list of pegs
     */
    private fun addPegsToList() {
        var id = 1
        pegList.map { pegs[id] = it; id++}
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
    override fun toString(): String = (pegs.map{peg -> peg.value.printColour()}).toString()

}
