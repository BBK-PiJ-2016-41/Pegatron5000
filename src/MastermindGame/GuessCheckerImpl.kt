package MastermindGame

import MastermindGame.Colours.Colour
import MastermindGame.Colours.ResultColourBlack
import MastermindGame.Colours.ResultColourWhite
import MastermindGame.Colours.ResultNoColour

class GuessCheckerImpl (private val secretPegCode: PegList): GuessChecker {

    /**
     * A map to hold the number of each colour in the secret peg code
     */
    private var codeColourMap: Map<String, Int>
    /**
     * A map to hold the number of each colour in the guess peg list
     */
    private lateinit var guessColourMap: Map<String, Int>
    /**
     * Stores the current guess that is being evaluated by the checker
     */
    private lateinit var pegGuess: PegList

    private lateinit var pegResult: List<Colour>

    /**
     * Upon initialisation, maps the colours in the peg code to indicate how many times each occurs
     */
    init {
        codeColourMap = mapColours(secretPegCode.getPegMap().map{it.value})
    }

    /**
     * Accepts a new guess into the guess checker for evaluation
     */
    override fun setGuess(newGuess: PegList) {
        pegGuess = newGuess
        guessColourMap = mapColours(pegGuess.getPegMap().map{it.value})
    }

    /**
     * Generates the result from the current guess held by the guess checker.
     */
    override fun generateResult(): List<Colour> {
        pegResult = pegGuess.getPegMap().map{checkPeg(it.value, it.key)}
        return pegResult
    }

    /**
     * A helper function for generateResult() that checks for an exact match between the guess peg colour and code peg colour
     */
    private fun checkPeg(peg: Peg, pegIndex: Int): Colour = when (peg.colour.name) {
        (secretPegCode.getPegMap()[pegIndex])!!.colour.name -> ResultColourBlack
        else -> checkAllColours(peg)
    }

    /**
     * A helper function for checkPeg() that checks for a colour match elsewhere in the guess code in the event of a failed match
     */
    private fun checkAllColours(pegToCheck: Peg): Colour {
        return if(codeColourMap.contains(pegToCheck.colour.name) && codeColourMap[pegToCheck.colour.name]!! >= guessColourMap[pegToCheck.colour.name]!!) ResultColourWhite
        else ResultNoColour
    }

    /**
     * Populates a map that shows how many of each colour peg appears in a given list
     */
    private fun mapColours(pegs: List<Peg>): Map<String, Int> {
        val map = hashMapOf<String, Int>()
        pegs.forEach{
            if(map.containsKey(it.colour.name))
            map[it.colour.name] = map[it.colour.name]!! + 1
            else map[it.colour.name] = 1
        }
        return map
    }

    /**
     *
     */
    override fun isCorrect() = pegResult.fold(false){bool, colour -> colour.name == "Black" && bool}
}