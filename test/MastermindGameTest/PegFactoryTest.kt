package MastermindGameTest

import MastermindGame.*
import MastermindGame.Colours.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.*

class PegFactoryTest {

    @Test
    fun testMakePegsNumber() {
        val pegList: PegList = PegFactory.makePegs(mutableListOf(Rcolour, Ycolour, Gcolour, Pcolour))
        assertEquals(4, pegList.getPegMap().size)
    }

    @Test
    fun testMakePegsColour() {
        val pegList: PegList = PegFactory.makePegs(mutableListOf(Rcolour, Ycolour, Gcolour, Pcolour))
        assertEquals("RYGP", pegList.toString())
    }

    @Test
    fun testMakePegsResult() {
        val pegList: PegList = PegFactory.makePegs(mutableListOf(ResultColourBlack, ResultColourBlack,
                ResultColourWhite, ResultNoColour))
        assertEquals(4, pegList.getPegMap().size)
    }

    // Test won't always pass - could conceivably shuffle into the same order.
    @Test
    fun testMakePegsResultShuffle() {
        val pegList: PegList = PegFactory.makePegs(mutableListOf(ResultColourBlack, ResultColourBlack,
                ResultColourWhite, ResultColourBlack))
        assertNotEquals("Black Black White Black ", pegList.toString())
    }


    @Test
    fun testFindingColours() {
        val fact = PegFactory
        val result = fact.findAvailableColours()
        val expected = mutableListOf<Colour>(Bcolour, Gcolour, Ocolour, Pcolour, Rcolour, Ycolour)
        assertEquals(expected, result)
    }

    @Test
    fun testGenerate4Colours() {
        val result = PegFactory.generateSequence(4)
        assertEquals(result.size, 4)
    }

    @Test
    fun testGenerate5Colours() {
        val result = PegFactory.generateSequence(5)
        assertEquals(result.size, 5)
    }

    @Test
    fun testGenerate10Colours() {
        val result = PegFactory.generateSequence(10)
        assertEquals(result.size, 10)
    }

    @Test
    fun testRandomness() {
        val result = PegFactory.generateSequence(4)
        val result2 = PegFactory.generateSequence(4)
        assertNotEquals(result,result2)
    }

    @Test
    fun testInterpretUserInput() {
        val result = PegFactory.interpretUserInput("BGOP", 4)
        val expected = mutableListOf<Peg>(PegImpl(Bcolour), PegImpl(Gcolour), PegImpl(Ocolour), PegImpl(Pcolour))
        assertEquals(expected.toString(), result.toString())
    }

    @Test (expected = InputMismatchException::class)
    fun testInterpretUserInputIncorrectLetter() {
        val result = PegFactory.interpretUserInput("jfhf", 4)
    }

    @Test (expected = InputMismatchException::class)
    fun testInterpretUserInputIncorrectLength() {
        val result = PegFactory.interpretUserInput("BGOPBGOP", 4)
    }

}