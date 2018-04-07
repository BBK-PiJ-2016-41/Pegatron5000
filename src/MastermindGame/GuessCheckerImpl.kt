package MastermindGame

class GuessCheckerImpl (private val secretPegCode: PegList): GuessChecker {

    private var codeColourMap: Map<String, Int>
    private lateinit var guessColourMap: Map<String, Int>
    private lateinit var pegGuess: PegList

    init {
        codeColourMap = mapColours(secretPegCode.getPegMap().map{peg -> peg.value})
    }

    override fun setGuess(newGuess: PegList) {
        pegGuess = newGuess
        guessColourMap = mapColours(pegGuess.getPegMap().map{peg -> peg.value})
    }

    override fun generateResult(): List<Colour> {
        return pegGuess.getPegMap().map{peg -> checkPeg(peg.value, peg.key)}
    }

    private fun checkPeg(peg: Peg, pegIndex: Int): Colour = when (peg.colour.name) {
        (secretPegCode.getPegMap()[pegIndex])!!.colour.name -> ResultColourBlack
        else -> checkAllColours(peg)
    }

    private fun checkAllColours(pegToCheck: Peg): Colour {
        return if(codeColourMap.contains(pegToCheck.colour.name) && codeColourMap[pegToCheck.colour.name]!! >= guessColourMap[pegToCheck.colour.name]!!) ResultColourWhite
        else ResultNoColour
    }

    private fun mapColours(pegs: List<Peg>): Map<String, Int> {
        val map = hashMapOf<String, Int>()
        pegs.forEach{
            peg -> if(map.containsKey(peg.colour.name))
            map[peg.colour.name] = map[peg.colour.name]!! + 1
            else map[peg.colour.name] = 1
        }
        return map
    }
}