package MastermindGame

class GuessCheckerImpl (private val secretPegCode: PegListGuessMock): GuessChecker {

    private lateinit var colourList: List<String>
    private lateinit var pegGuess: PegListGuessMock

    fun setGuess(newGuess: PegListGuessMock) {
        pegGuess = newGuess
    }

    fun generateResult(): PegList {
        // needs to be a map that includes indexes, because indexOf will return the index of the first peg that matches.
        return PegListResultsMock(pegGuess.pegList.map{peg -> checkPeg(peg, pegGuess.pegList.indexOf(peg))})
    }

    private fun checkPeg(peg: PegImplColourMock,pegIndex: Int): PegImplResultMock = when (peg.colour) {
        (secretPegCode.pegList[pegIndex]).colour -> PegImplResultMock("B")
        else -> checkAllColours(peg)
    }

    private fun checkAllColours(pegToCheck: PegImplColourMock): PegImplResultMock {
        colourList = secretPegCode.pegList.map{peg -> peg.colour}
        return if(colourList.contains(pegToCheck.colour)) PegImplResultMock("W") else (PegImplResultMock("_"))
    }
}