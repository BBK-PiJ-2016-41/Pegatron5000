package MastermindGame

import MastermindGame.Colours.Colour
import MastermindGame.Colours.ResultColourBlack
import MastermindGame.Colours.ResultColourWhite
import MastermindGame.Colours.ResultNoColour

class GuessCheckerImpl (private val secretPegCode: PegList): GuessChecker {

    /**
     * A map to hold the number of each colour in the secret peg code
     */
    private var codeColourMap: MutableMap<String, Int>
    /**
     * A map to hold the number of each colour in the guess peg list
     */
    private lateinit var guessColourMap: MutableMap<String, Int>
    /**
     * Stores the current guess that is being evaluated by the checker
     */
    private lateinit var pegGuess: PegList
    /**
     * Stores the result from the guess that is currently held by the checker
     */
    private lateinit var pegResult: List<Colour>

    /**
     * Upon initialisation, maps the colours in the peg code to indicate how many times each occurs
     */
    init {
        codeColourMap = mapColours(secretPegCode.getPegMap().map{it.value}) as MutableMap<String, Int>
    }

    override fun setGuess(newGuess: PegList) {
        pegGuess = newGuess
        guessColourMap = mapColours(pegGuess.getPegMap().map{it.value}) as MutableMap<String, Int>
        codeColourMap = mapColours(secretPegCode.getPegMap().map{it.value}) as MutableMap<String, Int>
    }

    override fun generateResult(): List<Colour> {
        pegResult = pegGuess.getPegMap().map{checkPegForBlacks(it.value, it.key)}.map{if(!(it is ResultColourBlack)) checkAllColours(it) else ResultColourBlack}
        return pegResult
    }

    /**
     * A helper function for generateResult() that checks for an exact match between the guess peg colour and code peg colour
     */
    private fun checkPegForBlacks(peg: Peg, pegIndex: Int): Colour = when (peg.colour.name) {
        (secretPegCode.getPegMap()[pegIndex])!!.colour.name -> {
            removePegColoursFromMaps(peg.colour.name)
            ResultColourBlack
        }
        else -> peg.colour
    }

    /**
     * A helper function for checkPeg() that checks for a colour match elsewhere in the guess code in the event of a failed match
     */
    private fun checkAllColours(colourToCheck: Colour): Colour {
        if (codeColourMap.containsKey(colourToCheck.name)) {
            if (codeColourMap[colourToCheck.name]!! <= guessColourMap[colourToCheck.name]!!) {
                removePegColoursFromMaps(colourToCheck.name)
                return ResultColourWhite
            }
        }
        return ResultNoColour
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

    private fun removePegColoursFromMaps(colour: String) {
        codeColourMap[colour] = codeColourMap[colour]!! - 1
        if (codeColourMap[colour] == 0) codeColourMap.remove(colour)
        guessColourMap[colour] = guessColourMap[colour]!! - 1
        if (guessColourMap[colour] == 0) guessColourMap.remove(colour)
    }

    override fun isCorrect() = pegResult.fold(true){bool, colour -> colour.name == "Black" && bool}
}