package MastermindGameTest

import MastermindGame.Colours.*
import MastermindGame.Peg
import MastermindGame.PegImpl
import org.junit.*
import kotlin.test.assertEquals

class PegTest {
    lateinit var redPeg: Peg
    lateinit var blackPeg: Peg

    @Before
    fun build() {
        redPeg = PegImpl(Rcolour)
        blackPeg = PegImpl(ResultColourBlack)
    }

    @Test
    fun testToStringColour() {
        assertEquals("R", redPeg.toString())
    }

    @Test
    fun testToStringResult() {
        assertEquals("Black ", blackPeg.toString())
    }

}