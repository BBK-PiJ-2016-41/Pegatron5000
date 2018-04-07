package MastermindGame

class ColourMock(override val name: String, override val letter: String) : Colour {

    override fun toString(): String {
        return name
    }
}