package MastermindGame

import MastermindGame.Colours.Colour
import java.util.*

object PegFactory {

    fun makePegs(input: MutableList<Colour>): PegList {
        val pegs = mutableListOf<Peg>()
        input.forEach { pegs.add(PegImpl(it)) } // Turn each colour into a peg and add to list

        return PegListImpl(pegs)
    }

    /**
     * method to generate sequence of colours
     * @param num : amount of colours needed, size of the sequence required
     * @param availableColours : array list of all the colours available to be used for the sequence
     * @return randomColours : array list of the colours selected randomly
     */
    fun generateSequence(num : Int) : ArrayList<Colour> {
        val availableColours = findAvailableColours()
        var randomColours = arrayListOf<Colour>()

        for(x in 1..num) {
            var randomLimit = availableColours.size
            var r = Random().nextInt(randomLimit)
            randomColours.add(availableColours[r])
        }

        return randomColours
    }


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
        var availableColours = mutableListOf<Colour>()
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

    //return mutable list of pegs
    fun interpretUserInput(userInput : String, numPegs: Int) : MutableList<Colour> {
        val colours = findAvailableColours().map{colour -> Pair<colour.letter, colour>}
        val result = userInput.split("").map{letter -> if(colours.containsKey(letter)) colours[colour.letter]
            else throw InvalidArgumentException("Please enter a string with valid colours")}
        if (result.length != numPegs) throw InvalidArgumentException("Please enter a string of length $numPegs")
        else return result
    }

}