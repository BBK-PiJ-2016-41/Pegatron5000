package MastermindGame

class PegListGuessMock(val peg1: PegImplColourMock, val peg2: PegImplColourMock, val peg3: PegImplColourMock, val peg4: PegImplColourMock) : PegList {
    fun pegList() = listOf(peg1, peg2, peg3, peg4)
}