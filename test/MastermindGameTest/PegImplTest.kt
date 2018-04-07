package MastermindGameTest

import MastermindGame.ColourMock
import MastermindGame.Peg
import MastermindGame.PegImplColour
import MastermindGame.PegImplResult
import org.junit.*
import kotlin.test.assertEquals

class PegImplTest {
    lateinit var colourPeg: Peg
    lateinit var resultPeg: Peg

    @Before
    fun build() {
        colourPeg = PegImplColour(ColourMock("Red", "R"))
        resultPeg = PegImplResult(ColourMock("Black", "Bl"))
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