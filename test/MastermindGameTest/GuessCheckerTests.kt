package MastermindGameTest

import MastermindGame.*
import MastermindGame.PegImplColourMock
import MastermindGame.PegImplResultMock
import MastermindGame.PegListGuessMock

import org.junit.Test
import kotlin.test.assertEquals

class GuessCheckerTests {

    val greenPeg = PegImplColourMock("G")
    val bluePeg = PegImplColourMock("B")
    val yellowPeg = PegImplColourMock("Y")
    val redPeg = PegImplColourMock("R")
    val whitePeg = PegImplResultMock("W")
    val blackPeg = PegImplResultMock("B")
    val secretCodeMock = PegListGuessMock(mutableListOf(greenPeg, bluePeg, greenPeg, redPeg))
    val guessChecker = GuessCheckerImpl(secretCodeMock, secretCodeMock)

    @Test
    fun sameCodeAllBlack() {
        val allBlackPegList = PegListResultsMock(listOf(blackPeg, blackPeg, blackPeg, blackPeg))
        assertEquals(allBlackPegList.toString(), guessChecker.generateResult().toString())
    }

    @Test
    fun onePegWrong() {
        val onePegWrongList = PegListResultsMock(listOf(blackPeg, blackPeg, blackPeg, whitePeg))
        guessChecker.setGuess(PegListGuessMock(mutableListOf(greenPeg, bluePeg, greenPeg, greenPeg)))
        assertEquals(onePegWrongList.toString(), guessChecker.generateResult().toString())
    }
}