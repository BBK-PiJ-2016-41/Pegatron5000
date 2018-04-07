package MastermindGame

class PegImpl(override val colour: Colour): Peg {
    override var type = ""

    init {
        type = when (colour.toString()) {
            "Black", "White", "None" -> "result"
            else -> "colour"
        }
    }

    override fun toString(): String {
        return colour.toString()
    }


}