package MastermindGame

class PegListGuessMock(val pegList: MutableList<PegImplColourMock>) : PegList {
    val pegMap = HashMap<Int, PegImplColourMock>()
    init {
        var index = 0
        for(peg in pegList) {
            pegMap[index] = peg
            index++
        }
    }
    override fun toString() = (pegMap.map{peg -> peg.value.colour}).toString()
}