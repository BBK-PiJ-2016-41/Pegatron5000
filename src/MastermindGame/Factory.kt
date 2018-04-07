package MastermindGame

object Factory {
    fun getInstance(c: Class<*>, b: Boolean?): Game = TODO()

    /**
     * Uses reflection to find all of the colour subclasses available in the Colours folder
     * As each letter of the alphabet only has one colour, runs through the alphabet and builds
     * the standardised name of each potential class
     * Then checks whether the class exists, and if it does adds it to the list of available colours
     * If it does not exist, a ClassNotFoundException is caught and the method looks for the next colour
     * 
     * @return availableColours : a list of colours found that the game can use
     */
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