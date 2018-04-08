import MastermindGame.ColourGenerator
import MastermindGame.Colours.*
import MastermindGame.Factory
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class FactoryTest {

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
}