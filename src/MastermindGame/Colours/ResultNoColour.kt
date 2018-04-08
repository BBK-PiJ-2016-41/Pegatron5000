package MastermindGame.Colours

class ResultNoColour : Colour {
    override val name: String = "None"
    override val letter: String = ""

    override fun toString(): String {
        return letter
    }

}