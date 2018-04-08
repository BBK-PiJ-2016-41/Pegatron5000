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
        val fact = Factory()
        val result = fact.findAvailableColours()
        val expected = mutableListOf<Colour>(Bcolour, Gcolour, Ocolour, Pcolour, Rcolour, Ycolour)
        assertEquals(expected, result)
    }

    @Test
    fun testGenerate4Colours() {
        val availableColours = arrayListOf<Colour>(Bcolour, Gcolour, Ocolour, Pcolour, Rcolour, Ycolour)
        val generator = ColourGenerator()
        val result = generator.generateSequence(4, availableColours)
        assertEquals(result.size, 4)

    }

    @Test
    fun testGenerate5Colours() {
        val availableColours = arrayListOf<Colour>(Bcolour, Gcolour, Ocolour, Pcolour, Rcolour, Ycolour)
        val generator = ColourGenerator()
        val result = generator.generateSequence(5, availableColours)
        assertEquals(result.size, 5)
    }

    @Test
    fun testGenerate10Colours() {
        val availableColours = arrayListOf<Colour>(Bcolour, Gcolour, Ocolour, Pcolour, Rcolour, Ycolour)
        val generator = ColourGenerator()
        val result = generator.generateSequence(10, availableColours)
        assertEquals(result.size, 10)
    }

    @Test
    fun testRandomness() {
        val availableColours = arrayListOf<Colour>(Bcolour, Gcolour, Ocolour, Pcolour, Rcolour, Ycolour)
        val generator = ColourGenerator()
        val result = generator.generateSequence(5, availableColours)
        val result2 = generator.generateSequence(5, availableColours)
        assertNotEquals(result,result2)
    }
}