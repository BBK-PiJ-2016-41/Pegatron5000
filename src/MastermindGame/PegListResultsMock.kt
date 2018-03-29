package MastermindGame

class PegListResultsMock(val peg1: Peg, val peg2: Peg, val peg3: Peg, val peg4: Peg) : PegList {
    fun pegList() = listOf(peg1, peg2, peg3, peg4)
}