package MastermindGameTest

import MastermindGame.ColourMock
import MastermindGame.Peg
import MastermindGame.PegColour
import MastermindGame.PegResult
import org.junit.*
import kotlin.test.assertEquals

class PegTest {
    lateinit var colourPeg: Peg
    lateinit var resultPeg: Peg

    @Before
    fun build() {
        colourPeg = PegColour(ColourMock("Red", "R"))
        resultPeg = PegResult(ColourMock("Black", "Bl"))
    }

    @Test
    fun testToStringColour() {
        assertEquals("Red", colourPeg.toString())
    }

    @Test
    fun testToStringResult() {
        assertEquals("Black", resultPeg.toString())
    }

}