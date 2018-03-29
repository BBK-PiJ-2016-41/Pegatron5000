package MastermindGame

class GuessCheckerImpl (private val secretPegCode: PegListGuessMock, private var pegGuess: PegListGuessMock): GuessChecker {

    private lateinit var colourList: List<String>

    fun setGuess(newGuess: PegListGuessMock) {
        pegGuess = newGuess
    }

    fun generateResult(): PegList = TODO()

    private fun checkPeg(pegIndex: Int): PegImplResultMock = TODO()

    private fun checkAllColours(pegToCheck: PegImplColourMock): PegImplResultMock {
        colourList = secretPegCode.pegList().map{peg -> peg.colour}
        val returnPeg: PegImplResultMock
        if (colourList.contains(pegToCheck.colour)) returnPeg = PegImplResultMock("W") else returnPeg = PegImplResultMock("BLANK")
        return returnPeg
    }
}