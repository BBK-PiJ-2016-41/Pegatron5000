package MastermindGame

object FactoryMock {
    fun getInstance(c: Class<*>, b: Boolean?): Game = TODO()

    fun findAvailableColours() : MutableList<Colour> {
        return mutableListOf(ColourMock("Red", "R"), ColourMock("Blue", "B"),
                ColourMock("Yellow", "Y"), ColourMock("Mauve", "M"),
                ColourMock("Pink", "P"), ColourMock("Silver", "S"),
                ColourMock("Ass", "A"), ColourMock("Cyan", "C"))
    }
}