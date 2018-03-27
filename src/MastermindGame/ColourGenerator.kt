package MastermindGame

import MastermindGame.Colours.Colour
import java.util.*
import kotlin.collections.ArrayList

class ColourGenerator {

    fun generateSequence(num : Int, availableColours : ArrayList<Colour>) : ArrayList<Colour> {
        var randomColours = arrayListOf<Colour>()

        for(x in 1..num) {
            var random = availableColours.size
            var r = Random().nextInt(random)
            randomColours.add(availableColours[r])
        }

        return randomColours
    }



}