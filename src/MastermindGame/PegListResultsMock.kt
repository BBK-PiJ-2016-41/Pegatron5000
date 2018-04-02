package MastermindGame

class PegListResultsMock(val pegs: List<PegImplResultMock>) : PegList {
    override fun toString() = (pegs.map{peg -> peg.colour}).toString()
}