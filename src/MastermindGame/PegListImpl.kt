package MastermindGame

/**
 * implementation of PegList that provides an abstraction for creating a set of different types of pegs
 *
 * @param numPegs the number of pegs that need to added to the peg list
 */
abstract class PegListImpl(val numPegs: Int) : PegList {

    override val pegs: MutableMap<Int, Peg> = mutableMapOf()

    /**
     * generates a map of pegs of the required type and size for use by the caller
     */
    init {
        addPegsToList()
    }

    /**
     * adds the specified number of pegs to the *pegs* list
     * validation is performed
     * each peg is assigned a numeric key value for use in interpreting the list of pegs
     * @return the list of pegs, or if validation fails, an empty list of pegs
     */
    private fun addPegsToList(): MutableMap<Int, Peg> = when {
        validatePegs() -> {
            for (n in 1..numPegs) {
                pegs.put(n, getNewPeg())
            }; pegs}
        else -> pegs // returns empty list that caller can deal with
    }

    /**
     * gets a new peg of the required type
     */
    abstract fun getNewPeg(): Peg

    /**
     * performs validation on the number of pegs requested
     */
    private fun validatePegs(): Boolean {
        return numPegs > 0
    }

}
