package MastermindGame

import MastermindGame.Colours.Colour
import java.util.*

object PegFactory {

    /**
     * method to generate a peg list from a list of colours
     * @param input : list of colours
     * @return PegList : PegListImpl object containing pegs of the specified colour and amount
     */
    fun makePegs(input: MutableList<Colour>): PegList {
        val pegs = mutableListOf<Peg>()
        input.forEach { pegs.add(PegImpl(it)) } // Turn each colour into a peg and add to list

        // Return a shuffled pegList if result, else return in the same order
        return when (input[0].toString()) {
            "White ", "Black ", "" -> PegListImpl(pegs.shuffled() as MutableList)
            else -> PegListImpl(pegs)
        }

    }

    /**
     * method to generate sequence of colours
     * @param num : amount of colours needed, size of the sequence required
     * @return randomColours : array list of the colours selected randomly
     */
    fun generateSequence(num : Int) : ArrayList<Colour> {
        val availableColours = findAvailableColours()
        var randomColours = arrayListOf<Colour>()
        for(x in 1..num) {
            randomColours.add(availableColours[Random().nextInt(availableColours.size)])
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
        val availableColours = mutableListOf<Colour>()
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


    /**
     * Takes a string from the userinput of colours they want to guess and turns it into a list
     * of colours so that it can become a peglist for comparison
     * Validates whether the input contains the colours and number of pegs being used in the game,
     * throwing an exception if not
     *
     * @param userInput: the string of the colour initials the user is guessing
     * @param numPegs: the number of pegs being used for this game
     * @return Mutable list of Colours that correspond to the input
     */
    fun interpretUserInput(userInput : String, numPegs: Int) : MutableList<Colour> {
        val colours = findAvailableColours().map{Pair(it.letter, it)}.toMap()
        val result = userInput.split("").filter{(colours.containsKey(it))}
                .map{colours[it] as Colour}.toMutableList()
        if (result.size != numPegs || userInput.length != numPegs) throw InputMismatchException("Please enter a string of length $numPegs with the correct colours")
        return result
    }

}