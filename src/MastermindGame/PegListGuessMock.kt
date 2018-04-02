package MastermindGame

class PegListGuessMock(val pegList: MutableList<PegImplColourMock>) : PegList {
    override fun toString() = (pegList.map{peg -> peg.colour}).toString()
}