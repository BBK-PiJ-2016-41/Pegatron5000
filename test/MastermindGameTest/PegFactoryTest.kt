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
        val colourList = PegFactory.makePegs(mutableListOf(ColourMock("Red", "R"),
                ColourMock("Yellow", "Y"), ColourMock("Mauve", "M"),
                ColourMock("Pink", "P")))
        val expected = "[Red, Yellow, Mauve, Pink]"
        assertEquals(expected, colourList.toString())
    }

    @Test
    fun testMakeResultPegList() {
        val resultList = PegFactory.makePegs(mutableListOf(ColourMock("Black", "Bl"),
                ColourMock("White", "Wh"), ColourMock("White", "Wh"),
                ColourMock("None", "")))
        val expected = "[Black, White, White, None]"
        assertEquals(expected, resultList.toString())
    }

    @Test
    fun testFindingColours() {
        val fact = Factory
        val result = fact.findAvailableColours()
        val expected = mutableListOf<Colour>(Bcolour, Gcolour, Ocolour, Pcolour, Rcolour, Ycolour)
        assertEquals(expected, result)
    }

    @Test
    fun testGenerate4Colours() {
        val result = Factory.generateSequence(4)
        assertEquals(result.size, 4)
    }

    @Test
    fun testGenerate5Colours() {
        val result = Factory.generateSequence(5)
        assertEquals(result.size, 5)
    }

    @Test
    fun testGenerate10Colours() {
        val result = Factory.generateSequence(10)
        assertEquals(result.size, 10)
    }

    @Test
    fun testRandomness() {
        val result = Factory.generateSequence(4)
        val result2 = Factory.generateSequence(4)
        assertNotEquals(result,result2)
    }

    @Test
    fun testInterpretUserInput() {
        val result = Factory.interpretUserInput("BGOP")
        val expected = mutableListOf<Peg>(PegImpl(Bcolour), PegImpl(Gcolour), PegImpl(Ocolour), PegImpl(Pcolour))
        assertEquals(expected.toString(), result.toString())
    }

}