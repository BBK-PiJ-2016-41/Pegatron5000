package MastermindGameTest

import MastermindGame.*
import org.junit.Test
import java.security.PermissionCollection
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class GuessValidatorTests {
    val guessValidator = GuessValidator(4)
    val greenPeg = PegImplColourMock("G")
    val secondGreen = PegImplColourMock("G")
    val thirdGreen = PegImplColourMock("G")
    val bluePeg = PegImplColourMock("B")
    val pegList = PegListGuessMock(mutableListOf(greenPeg, secondGreen, thirdGreen, bluePeg))

    @Test
    fun checksGuessLength() {
        assertTrue(guessValidator.checkGuess(pegList))
        val shortList = PegListGuessMock(mutableListOf(greenPeg, bluePeg, secondGreen))
        assertFalse(guessValidator.checkGuess(shortList))
    }
}