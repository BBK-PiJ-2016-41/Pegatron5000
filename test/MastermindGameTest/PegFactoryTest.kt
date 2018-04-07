package MastermindGameTest

import MastermindGame.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class PegFactoryTest {
    var listLength = 0

    @Before
    fun build() {
        PegFactory.startFactory(4)
        listLength = PegFactory.listLength
    }

    @Test
    fun testListLength() {
        assertEquals(4, PegFactory.listLength)
    }

    @Test
    fun testMakeColourPegList() {
        val colourList = PegFactory.makeColourPegs(mutableListOf(ColourMock("Red", "R"),
                ColourMock("Yellow", "Y"), ColourMock("Mauve", "M"),
                ColourMock("Pink", "P")))
        val expected = "[Red, Yellow, Mauve, Pink]"
        assertEquals(expected, colourList.toString())
    }

    @Test
    fun testMakeResultPegList() {
        val resultList = PegFactory.makeColourPegs(mutableListOf(ColourMock("Black", "Bl"),
                ColourMock("White", "Wh"), ColourMock("White", "Wh"),
                ColourMock("None", "")))
        val expected = "[Black, White, White, None]"
        assertEquals(expected, resultList.toString())
    }

}