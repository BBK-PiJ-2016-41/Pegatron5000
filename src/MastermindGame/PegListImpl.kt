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
     * validation is performed against number of pegs requested
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
        return numPegs >= 4
    }

}

//changed List to MutableList
//got rid of type parameter seeing as we now have concrete implementations for colour and result
//validated that >= 4 pegs should be specified
//if empty list returned then caller can deal with it
//what validation needs performing?