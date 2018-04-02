package MastermindGame

class GuessCheckerImpl (private val secretPegCode: PegListGuessMock, private var pegGuess: PegListGuessMock): GuessChecker {

    private lateinit var colourList: List<String>

    fun setGuess(newGuess: PegListGuessMock) {
        pegGuess = newGuess
    }

    fun generateResult(): PegList {
        return PegListResultsMock(pegGuess.pegList.map{peg -> checkPeg(peg, 0)})
    }

    private fun checkPeg(peg: PegImplColourMock,pegIndex: Int): PegImplResultMock = when (peg.colour) {
        (secretPegCode.pegList[pegIndex]).colour -> PegImplResultMock("B")
        else -> checkAllColours(peg)
    }

    private fun checkAllColours(pegToCheck: PegImplColourMock): PegImplResultMock {
        colourList = secretPegCode.pegList.map{peg -> peg.colour}
        return if(colourList.contains(pegToCheck.colour)) PegImplResultMock("W") else (PegImplResultMock("BLANK"))
    }
}