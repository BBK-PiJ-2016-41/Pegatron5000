package MastermindGame

class GuessCheckerImpl (private val secretPegCode: PegListGuessMock): GuessChecker {

    private lateinit var colourList: List<String>
    private lateinit var pegGuess: PegListGuessMock

    fun setGuess(newGuess: PegListGuessMock) {
        pegGuess = newGuess
    }

    fun generateResult(): PegList {
        // needs to be a map that includes indexes, because indexOf will return the index of the first peg that matches.
        return PegListResultsMock(pegGuess.pegMap.map{peg -> checkPeg(peg.value, peg.key)})
    }

    private fun checkPeg(peg: PegImplColourMock, pegIndex: Int): PegImplResultMock = when (peg.colour) {
        (secretPegCode.pegMap[pegIndex])!!.colour -> PegImplResultMock("B")
        else -> checkAllColours(peg)
    }

    private fun checkAllColours(pegToCheck: PegImplColourMock): PegImplResultMock {
        colourList = secretPegCode.pegList.map{peg -> peg.colour}
        return if(colourList.contains(pegToCheck.colour)) PegImplResultMock("W") else (PegImplResultMock("_"))
    }
}