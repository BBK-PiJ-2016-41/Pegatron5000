package MastermindGameTest

import MastermindGame.ColourGenerator
import MastermindGame.Colours.*
import com.sun.org.apache.bcel.internal.util.BCELifier
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ColourGeneratorTest {
    lateinit var availableColours : ArrayList<Colour>
    @Before
    fun initial() {
        val b = Bcolour()
        val g = Gcolour()
        val o = Ocolour()
        val p = Pcolour()
        val r = Rcolour()
        val y = Ycolour()

        val availableColours = arrayListOf<Colour>(b, g, o, p, r, y)
    }

    @Test
    fun testGenerate4Colours() {
        val b = Bcolour()
        val g = Gcolour()
        val o = Ocolour()
        val p = Pcolour()
        val r = Rcolour()
        val y = Ycolour()

        val availableColours = arrayListOf<Colour>(b, g, o, p, r, y)
        val generator = ColourGenerator()
        val result = generator.generateSequence(4, availableColours)
        assertEquals(result.size, 4)
    }

    @Test
    fun testGenerate5Colours() {
        val b = Bcolour()
        val g = Gcolour()
        val o = Ocolour()
        val p = Pcolour()
        val r = Rcolour()
        val y = Ycolour()

        val availableColours = arrayListOf<Colour>(b, g, o, p, r, y)
        val generator = ColourGenerator()
        val result = generator.generateSequence(5, availableColours)
        assertEquals(result.size, 5)
    }

    @Test
    fun testGenerate10Colours() {
        val b = Bcolour()
        val g = Gcolour()
        val o = Ocolour()
        val p = Pcolour()
        val r = Rcolour()
        val y = Ycolour()

        val availableColours = arrayListOf<Colour>(b, g, o, p, r, y)
        val generator = ColourGenerator()
        val result = generator.generateSequence(10, availableColours)
        assertEquals(result.size, 10)
    }
}