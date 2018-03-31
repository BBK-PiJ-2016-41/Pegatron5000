package MastermindGame

/**
 * implementation of PegList that provides an abstraction for creating lists of different types of pegs
 *
 * @param numPegs the number of pegs that need to added to the peg list
 */
abstract class PegListImpl(val numPegs: Int) : PegList {

    override val pegs: MutableList<Peg> = mutableListOf()

    /**
     * generates a list of pegs of the required type and size for use by the caller
     */
    init {
        addPegsToList()
    }

    /**
     * adds the specified number of pegs to the *pegs* list
     * validation is performed
     * @return the list of pegs, or if validation fails, an empty list of pegs
     */
    private fun addPegsToList(): MutableList<Peg> = when {
        validatePegs() -> {
            for (n in 0..numPegs) {
                pegs.add(getNewPeg())
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
        //add in validations
        return true
    }

}