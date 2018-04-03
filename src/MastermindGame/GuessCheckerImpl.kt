package MastermindGame

class GuessCheckerImpl (private val secretPegCode: PegListGuessMock): GuessChecker {

    private var codeColourMap: Map<String, Int>
    private lateinit var guessColourMap: Map<String, Int>
    private lateinit var pegGuess: PegListGuessMock

    init {
        codeColourMap = mapColours(secretPegCode)
    }

    fun setGuess(newGuess: PegListGuessMock) {
        pegGuess = newGuess
        guessColourMap = mapColours(pegGuess)
    }

    fun generateResult(): PegList {
        return PegListResultsMock(pegGuess.pegMap.map{peg -> checkPeg(peg.value, peg.key)})
    }

    private fun checkPeg(peg: PegImplColourMock, pegIndex: Int): PegImplResultMock = when (peg.colour) {
        (secretPegCode.pegMap[pegIndex])!!.colour -> PegImplResultMock("B")
        else -> checkAllColours(peg)
    }

    private fun checkAllColours(pegToCheck: PegImplColourMock): PegImplResultMock {
        return if(codeColourMap.contains(pegToCheck.colour) && codeColourMap[pegToCheck.colour]!! >= guessColourMap[pegToCheck.colour]!!) PegImplResultMock("W")
        else (PegImplResultMock("_"))
    }

    private fun mapColours(pegs: PegListGuessMock): Map<String, Int> {
        val map = hashMapOf<String, Int>()
        pegs.pegList.forEach{
            peg -> if(map.containsKey(peg.colour))
            map[peg.colour] = map[peg.colour]!! + 1
            else map[peg.colour] = 1
        }
        return map
    }
}