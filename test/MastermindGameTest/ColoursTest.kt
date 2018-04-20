package MastermindGameTest
import MastermindGame.Colours.*
import org.junit.Test
import kotlin.math.exp
import kotlin.test.assertEquals

class ColoursTest {

    @Test
    fun testBcolour() {
        val expected = "B"
        val actual = Bcolour.toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testGcolour() {
        val expected = "G"
        val actual = Gcolour.toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testOcolour() {
        val expected = "O"
        val actual = Ocolour.toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testPcolour() {
        val expected = "P"
        val actual = Pcolour.toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testRcolour() {
        val expected = "R"
        val actual = Rcolour.toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testYcolour() {
        val expected = "Y"
        val actual = Ycolour.toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testBlackcolour() {
        val expected = "Black "
        val actual = ResultColourBlack.toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testWhitecolour() {
        val expected = "White "
        val actual = ResultColourWhite.toString()
        assertEquals(expected, actual)
    }
}