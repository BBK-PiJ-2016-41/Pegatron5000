package MastermindGame

object Factory {
    fun getInstance(c: Class<*>, b: Boolean?): Game = TODO()

    fun findAvailableColours() : MutableList<Colour> {
        var availableColours = mutableListOf<Colour>();
        val colourLetters = arrayListOf<String>("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")

        for(letter in colourLetters) {
            try {
                val classCalled = "MastermindGame.Colours." + letter + "colour"
                val reflectClass = Class.forName(classCalled).kotlin.objectInstance as Colour
                availableColours.add(reflectClass)
            } catch(e: ClassNotFoundException) {
                //if class is not found it means that there isn't a class of that name so skips over it
            } catch(e: Exception) {
                //no other exceptions expected, so alerts user if this is the case
                print("An unexpected exception $e has been found")
            }
        }
        return availableColours
    }
}