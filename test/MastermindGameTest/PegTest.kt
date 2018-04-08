package MastermindGameTest

import MastermindGame.Peg
import MastermindGame.PegImpl
import org.junit.*
import kotlin.test.assertEquals

class PegTest {
    lateinit var colourPeg: Peg
    lateinit var resultPeg: Peg

    @Before
    fun build() {
        colourPeg = PegImpl(ColourMock("Red", "R"))
        resultPeg = PegImpl(ColourMock("Black", "Bl"))
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