package MastermindGame

import MastermindGame.Colours.Colour
import java.util.*
import kotlin.collections.ArrayList

class ColourGenerator {

    /**
     * method to generate sequence of colours
     * @param num : amount of colours needed, size of the sequence required
     * @param availableColours : array list of all the colours available to be used for the sequence
     * @return randomColours : array list of the colours selected randomly
     */
    fun generateSequence(num : Int, availableColours : ArrayList<Colour>) : ArrayList<Colour> {
        var randomColours = arrayListOf<Colour>()

        for(x in 1..num) {
            var randomLimit = availableColours.size
            var r = Random().nextInt(randomLimit)
            randomColours.add(availableColours[r])
        }

        return randomColours
    }



}