package MastermindGame

import MastermindGame.Colours.Colour
import java.util.*

interface PegFactory {

    /**
     * mMthod to generate a peg list from a list of Colour objects
     * @param input : list of Colours
     * @return PegList : PegListImpl object containing pegs of the specified colour and amount
     */
    fun makePegs(input: MutableList<Colour>): PegList

    /**
     * method to generate sequence of colours
     * @param num : amount of colours needed, size of the sequence required
     * @return randomColours : array list of the colours selected randomly
     */
    fun generateSequence(num : Int) : ArrayList<Colour>


    /**
     * Uses reflection to find all of the colour subclasses available in the Colours folder
     * As each letter of the alphabet only has one colour, runs through the alphabet and builds
     * the standardised name of each potential class
     * Then checks whether the class exists, and if it does adds it to the list of available colours
     * If it does not exist, a ClassNotFoundException is caught and the method looks for the next colour
     *
     * @return availableColours : a list of colours found that the game can use
     */
    fun findAvailableColours() : MutableList<Colour>


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
    fun interpretUserInput(userInput : String, numPegs: Int) : MutableList<Colour>
}