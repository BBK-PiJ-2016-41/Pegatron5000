package MastermindGameTest

import MastermindGame.*
import MastermindGame.Colours.*
import org.junit.Assert.*
import org.junit.Test
import java.util.*

class PegFactoryImplTest {

    @Test
    fun testMakePegsNumber() {
        val pegList: PegList = PegFactoryImpl.makePegs(mutableListOf(Rcolour, Ycolour, Gcolour, Pcolour))
        assertEquals(4, pegList.getPegMap().size)
    }

    @Test
    fun testMakePegsColour() {
        val pegList: PegList = PegFactoryImpl.makePegs(mutableListOf(Rcolour, Ycolour, Gcolour, Pcolour))
        assertEquals("RYGP", pegList.toString())
    }

    @Test
    fun testMakePegsResult() {
        val pegList: PegList = PegFactoryImpl.makePegs(mutableListOf(ResultColourBlack, ResultColourBlack,
                ResultColourWhite, ResultNoColour))
        assertEquals(4, pegList.getPegMap().size)
    }

    // Test won't always pass - could conceivably shuffle into the same order.
    @Test
    fun testMakePegsResultShuffle() {
        val pegList: PegList = PegFactoryImpl.makePegs(mutableListOf(ResultColourBlack, ResultColourBlack,
                ResultColourWhite, ResultColourBlack))
        assertNotEquals("Black Black White Black ", pegList.toString())
    }


    @Test
    fun testFindingColours() {
        val fact = PegFactoryImpl
        val result = fact.findAvailableColours()
        val expected = mutableListOf<Colour>(Bcolour, Gcolour, Ocolour, Pcolour, Rcolour, Ycolour)
        assertEquals(expected, result)
    }

    @Test
    fun testGenerate4Colours() {
        val result = PegFactoryImpl.generateSequence(4)
        assertEquals(result.size, 4)
    }

    @Test
    fun testGenerate5Colours() {
        val result = PegFactoryImpl.generateSequence(5)
        assertEquals(result.size, 5)
    }

    @Test
    fun testGenerate10Colours() {
        val result = PegFactoryImpl.generateSequence(10)
        assertEquals(result.size, 10)
    }

    @Test
    fun testRandomness() {
        val result = PegFactoryImpl.generateSequence(4)
        val result2 = PegFactoryImpl.generateSequence(4)
        assertNotEquals(result,result2)
    }

    @Test
    fun testInterpretUserInput() {
        val result = PegFactoryImpl.interpretUserInput("BGOP", 4)
        val expected = mutableListOf<Peg>(PegImpl(Bcolour), PegImpl(Gcolour), PegImpl(Ocolour), PegImpl(Pcolour))
        assertEquals(expected.toString(), result.toString())
    }

    @Test (expected = InputMismatchException::class)
    fun testInterpretUserInputIncorrectLetter() {
        val result = PegFactoryImpl.interpretUserInput("jfhf", 4)
    }

    @Test (expected = InputMismatchException::class)
    fun testInterpretUserInputIncorrectLength() {
        val result = PegFactoryImpl.interpretUserInput("BGOPBGOP", 4)
    }

}