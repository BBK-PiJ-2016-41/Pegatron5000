package MastermindGameTest

import MastermindGame.*
import MastermindGame.Colours.*
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
        val result = PegFactory.interpretUserInput("BGOP")
        val expected = mutableListOf<Peg>(PegImpl(Bcolour), PegImpl(Gcolour), PegImpl(Ocolour), PegImpl(Pcolour))
        assertEquals(expected.toString(), result.toString())
    }

}