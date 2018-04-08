package MastermindGame

/**
 * a container to store the required number and type of pegs
 */
interface PegList {

    /**
     * returns a map of pegs requested by the caller
     *
     * @return a map of pegs plus associated numeric id
     */
    fun getPegMap(): MutableMap<Int, Peg>


}