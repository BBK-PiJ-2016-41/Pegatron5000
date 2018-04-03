package MastermindGame

/**
 * a container to store the required number and type of pegs
 */
interface PegList {

    /**
     * the container that stores pegs
     * an integer key allows pegs to be accessed
     */
    val pegs: MutableMap<Int, Peg>

}